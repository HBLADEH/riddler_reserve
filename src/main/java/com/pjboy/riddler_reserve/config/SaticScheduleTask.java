package com.pjboy.riddler_reserve.config;

import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.service.ResourceService;
import com.pjboy.riddler_reserve.service.util.UploadTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务
 */

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    ResourceService resourceService;
    @Autowired
    UploadTools uploadTools;

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
        }else
            System.err.println("没有需要清除的资源........................");
        System.err.println("清除资源缓存任务执行完毕........................");
    }
}