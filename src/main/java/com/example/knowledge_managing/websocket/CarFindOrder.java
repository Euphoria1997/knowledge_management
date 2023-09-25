//package com.example.knowledge_managing.websocket;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.knowledge_managing.common.CarWithCurrentPos;
//import com.example.knowledge_managing.entity.Car;
//import com.example.knowledge_managing.entity.Ride;
//import com.example.knowledge_managing.service.IRideService;
//import com.example.knowledge_managing.util.GeoUtil;
//import com.example.knowledge_managing.util.RespCode;
//import com.example.knowledge_managing.util.RespResult;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.geo.Point;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.Set;
//import java.util.concurrent.CopyOnWriteArrayList;
//
///**
// * @ServerEndPoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端，
// * 注解的值将被用于监听用户连接的终端访问URL地址，客户端可以通过这个URL连接到websocket服务器端
// */
//@ServerEndpoint("/ws/carFindOrder")
//@Component
//@Slf4j
//public class CarFindOrder {
//
//    private static IRideService iRideService;
//
//
//    private static RedisTemplate redisTemplate;
//
//    private static GeoUtil geoUtil;
//    //需加上对应license
//    private static String CAR_SEARCH_QUEUE = "wenwen:ride:searchOrder:";
//
//    public static Hashtable<String, Session> sessions = new Hashtable<>();
////    难以监控，使用redis替换
////    private static String CAR_SESSION_MAP = "wenwen:ride:carSession:";
//    //储存一个session的集合，找到订单后或订单完成后通知它
//
//
//    @Autowired
//    public CarFindOrder(IRideService iRideService, RedisTemplate redisTemplate, GeoUtil geoUtil) {
//        CarFindOrder.geoUtil = geoUtil;
//        CarFindOrder.iRideService = iRideService;
//        CarFindOrder.redisTemplate = redisTemplate;
//
//    }
//
//    public CarFindOrder() {
//    }
//
////    private Session session;
//
//    /**
//     * 创建车辆对于服务器的连接
//     *
//     * @param session
//     */
//    @OnOpen
//    public void onOpen(Session session) {
//        //这里的session.getID记录的是连接ID，从0开始分配
//        log.info("有新连接加入！当前连接SessionID{}", session.getId());
//    }
//
//    @OnClose
//    public void onClose() {
//        log.info("有车辆session对应的连接已关闭");
//
//    }
//
//    //定义操作类型以及操作执行方式（switch-case）{string:action,data:data}
//    @OnMessage
//    public void onMessage(String message, Session session) throws IOException {
//        JSONObject tem = JSONObject.parseObject(message);
//        System.out.println("来自客户端的消息：" + message);
//        String data = tem.getString("data");
//        String action = tem.getString("action");
////        JSONObject test = new JSONObject();
////        test.put("action","rideReady");
////        session.getBasicRemote().sendText(test.toString());
//        switch (action) {
//            case "initConnection": {
//                String license = JSONObject.parseObject(data).getString("license");
//                Session oSession = sessions.get(license);
//                //标记车辆与session关系，如果重复将之前的关闭,检验是否一致，不一致将之前的连接断开
//                if (oSession != null) {
//                    if (!session.equals(oSession)) {
//                        log.info("该车辆存在过去的session{}正在销毁", session);
//                        oSession.close();
//                    }
//                }
//                sessions.put(license, session);
//                break;
//            }
//            case "initSearch": {
//                CarWithCurrentPos carWithCurrentPos = JSONObject.parseObject(data, CarWithCurrentPos.class);
//                Car car = carWithCurrentPos.getCar();
//                String license = car.getLicense();
//                log.info("车辆{}开始寻找附近的乘客", car.getLicense());
//                CarFindOrder.redisTemplate.opsForValue().set(CAR_SEARCH_QUEUE + license, carWithCurrentPos);
//                //将车辆信息加入geo中
//                Point pos = carWithCurrentPos.getPoint();
//                CarFindOrder.iRideService.addOrUpdateCar(license, pos.getX(), pos.getY());
//                break;
//            }
//            case "updateCarPos": {
//                CarWithCurrentPos carWithCurrentPos = JSONObject.parseObject(data, CarWithCurrentPos.class);
//                Car car = carWithCurrentPos.getCar();
//                String license = car.getLicense();
//                Point pos = carWithCurrentPos.getPoint();
//                iRideService.addOrUpdateCar(license, pos.getX(), pos.getY());
//                break;
//            }
//            case "stopSearchRides": {
//                String license = JSONObject.parseObject(data).getString("license");
//                redisTemplate.delete(CAR_SEARCH_QUEUE + license);
//                log.info("车辆{}停止搜寻乘客", license);
//                //删除GEO中的数据
//                geoUtil.geoRemove(license);
//                break;
//            }
//        }
//
//    }
//
//
//    //   下面是自定义的一些方法
////    public void sendMessage(String message) throws IOException {
////        this.session.getBasicRemote().sendText(message);
////    }
//    public static void informDriver(String license, JSONObject message) {
//        try {
//            Session session = sessions.get(license);
//            session.getBasicRemote().sendText(message.toString());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void closeSocket(Integer pid) {
//        try {
//            Session session = sessions.get(pid);
//            sessions.remove(pid);
//            session.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}