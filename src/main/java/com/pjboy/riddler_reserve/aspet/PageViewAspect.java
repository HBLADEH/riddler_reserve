package com.pjboy.riddler_reserve.aspet;

import com.pjboy.riddler_reserve.utils.IpUtils;
import com.pjboy.riddler_reserve.utils.RedisUtils;
import com.power.common.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Aspect
@Configuration
@Slf4j
public class PageViewAspect {

    @Autowired
    private RedisUtils redisUtil;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.pjboy.riddler_reserve.config.PageView)")
    public void PageViewAspect() {

    }

    /**
     * 切入处理
     *
     * @param joinPoint
     * @return
     */
    @Around("PageViewAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
//        Object[] object = joinPoint.getArgs();
//        Object articleId = object[0];
//        log.info("articleId:{}", articleId);
        Object obj = null;
        try {
            String ipAddr = IpUtils.getIpAddr();
            log.info("ipAddr:{}", ipAddr);
            String str = DateTimeUtil.dateToStr(new Date(), DateTimeUtil.DATE_FORMAT_DAY);
            String key = "view_" + str;
            // 浏览量存入redis中
            Long num = redisUtil.add(key, ipAddr);
            if (num == 0) {
                log.info("该ip:{},访问的浏览量已经新增过了", ipAddr);
            }
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }
}