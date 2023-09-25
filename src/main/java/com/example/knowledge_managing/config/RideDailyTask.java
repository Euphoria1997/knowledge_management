//package com.example.knowledge_managing.config;
//
//import com.example.knowledge_managing.common.OrderWithStartPos;
//import com.example.knowledge_managing.entity.Ride;
//import com.example.knowledge_managing.mapper.DailyRideNumMapper;
//import com.example.knowledge_managing.service.IRideService;
//import com.example.knowledge_managing.util.GeoUtil;
//import com.example.knowledge_managing.websocket.PassengerOrder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDateTime;
//import java.util.Hashtable;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//// 1.开启配置注解，使得spring能够扫描
//@Configuration
//// 2.开启定时任务
//@EnableScheduling
//@Slf4j
//public class RideDailyTask {
//
//    @Autowired
//    DailyRideNumMapper dailyRideNumMapper;
//    @Autowired
//    IRideService iRideService;
//    @Autowired
//    RedisTemplate redisTemplate;
//    @Autowired
//    GeoUtil geoUtil;
//    //定时每天0点触发
//    @Scheduled(cron = "0 0 0 * * ? ")
////定时任务仅执行一次（测试用）
////    @Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
//    private void configureTasks() {
//        System.out.println(LocalDateTime.now().minusDays(1L).toLocalDate());
//        dailyRideNumMapper.insertDayRideNumByDay(LocalDateTime.now().minusDays(1L).toLocalDate());
//    }
////遍历乘客队列，寻找附近是否有匹配上的司机
//    @Scheduled(initialDelay = 1000, fixedRate = 5000)
//    private void matchTasks() {
//        Hashtable passengerQueue = PassengerOrder.getOrderWithStartPoss();
//        if (passengerQueue.size()==0){
////            log.info("暂无正在寻求车辆的用户");
//            //提前结束
//            return;
//        }
//        Set entry = passengerQueue.entrySet();
//        Iterator<Map.Entry> it = entry.iterator();
//        while (it.hasNext()) {
//            Map.Entry entry1=it.next();
//            OrderWithStartPos tem = (OrderWithStartPos) entry1.getValue();
//            Ride tem2 = new Ride();
//            tem2.setPid(tem.getPid());
//            tem2.setOriginPrice(tem.getOriginPrice());
//            tem2.setStart(tem.getStart());
//            tem2.setDestinition(tem.getDestinition());
//            if (iRideService.passengerMatch(tem2,tem.getStartPos().getX(),tem.getStartPos().getY())){
//                PassengerOrder.getOrderWithStartPoss().remove(tem.getPid());
//            }
//        }
//    }
//}
