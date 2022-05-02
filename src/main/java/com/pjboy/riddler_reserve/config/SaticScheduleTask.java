package com.pjboy.riddler_reserve.config;

import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.ViewsDO;
import com.pjboy.riddler_reserve.service.ResourceService;
import com.pjboy.riddler_reserve.service.ViewsService;
import com.pjboy.riddler_reserve.service.util.UploadTools;
import com.pjboy.riddler_reserve.utils.RedisUtils;
import com.power.common.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 定时任务
 */

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {

    @Autowired
    ResourceService resourceService;

    @Autowired
    UploadTools uploadTools;

    @Resource
    private RedisUtils redisUtil;

    @Autowired
    private ViewsService viewsService;

    //3.添加定时任务 (每月10号4点15分钟执行任务)
    @Scheduled(cron = "0 15 4 10 * ?")
    //或直接指定时间间隔，例如：5秒
//    @Scheduled(cron = "0/5 * * * * ?")
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("开始执行清除资源缓存任务........................");
        List<ResourceDO> resources = resourceService.selectBadResource();
        if (resources.size() > 0) {
            uploadTools.deleteFileByResources(resources);
            resourceService.clearBadResource();
        } else
            System.err.println("没有需要清除的资源........................");
        System.err.println("清除资源缓存任务执行完毕........................");
    }


    // 每天凌晨一点执行
    @Scheduled(cron = "0 0 1 * * ? ")
//    @Scheduled(cron = "0/5 * * * * ?")
    public void createHyperLog() {
        log.info("浏览量入库开始");
        String today = DateTimeUtil.dateToStr(new Date(), DateTimeUtil.DATE_FORMAT_DAY);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        String yesterday = DateTimeUtil.dateToStr(calendar.getTime(), DateTimeUtil.DATE_FORMAT_DAY);

        ArrayList<String> days = new ArrayList<>() {
            {
                add(today);
                add(yesterday);
            }
        };
        days.forEach(day -> {
            // 获取每一篇文章在redis中的浏览量，存入到数据库中
            String key = "view_" + day;
            Long view = redisUtil.size(key);
            if (view > 0) {
                ViewsDO viewsDO = viewsService.getViewsByDate(day);
                long views;
                int num;
                if (viewsDO != null) {
                    views = view + viewsDO.getViews();
                } else {
                    viewsService.insertViews(day);
                    views = view;
                }
                num = viewsService.updateViewsByDate(views, day);
                if (num != 0) {
                    log.info("数据库更新后的浏览量为：{}", views);
                    redisUtil.del(key);
                }
            }
        });
        log.info("浏览量入库结束");
    }
}