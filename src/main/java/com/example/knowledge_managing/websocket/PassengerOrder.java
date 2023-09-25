//package com.example.knowledge_managing.websocket;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.knowledge_managing.common.CarWithCurrentPos;
//import com.example.knowledge_managing.common.OrderWithStartPos;
//import com.example.knowledge_managing.common.RideWithStartPos;
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
//import java.util.*;
//import java.util.concurrent.CopyOnWriteArrayList;
//
///**
// * @ServerEndPoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端，
// * 注解的值将被用于监听用户连接的终端访问URL地址，客户端可以通过这个URL连接到websocket服务器端
// */
//@ServerEndpoint("/ws/PassengerOrder")
//@Component
//@Slf4j
//public class PassengerOrder {
//    private static IRideService iRideService;
//
//    private static RedisTemplate redisTemplate;
//    private static GeoUtil geoUtil;
//    //需加上对应license
//    public final static String PASSENGER_SEARCH_QUEUE = "wenwen:ride:orderWithStartPos:";
//
//    private static Hashtable<Integer, Session> sessions = new Hashtable<>();
//
//    private static Hashtable<Integer,OrderWithStartPos> orderWithStartPoss = new Hashtable<>();
////    难以监控，使用redis替换
////    private static String CAR_SESSION_MAP = "wenwen:ride:carSession:";
//    //储存一个session的集合，找到订单后或订单完成后通知它
//    public static Hashtable<Integer,OrderWithStartPos> getOrderWithStartPoss(){
//        return orderWithStartPoss;
//    }
//
//    @Autowired
//    public PassengerOrder(IRideService iRideService, RedisTemplate redisTemplate, GeoUtil geoUtil) {
//        PassengerOrder.geoUtil = geoUtil;
//        PassengerOrder.iRideService = iRideService;
//        PassengerOrder.redisTemplate = redisTemplate;
//
//    }
//
//    public PassengerOrder() {
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
//        log.info("有新的乘客加入，SessionID为{}", session.getId());
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
//        log.info("来自客户端的消息{}", message);
//        String data = tem.getString("data");
//        String action = tem.getString("action");
//        switch (action) {
//            case "initConnection": {
//                Integer pid = JSONObject.parseObject(data).getInteger("pid");
//                Session oSession = sessions.get(pid);
//                //标记顾客与session关系，如果重复将之前的关闭,检验是否一致，不一致将之前的连接断开
//                if (oSession != null) {
//                    if (!session.equals(oSession)) {
//                        log.info("该乘客存在过去的session{}正在销毁", session);
//                        oSession.close();
//                    }
//                }
//                sessions.put(pid, session);
//                break;
//            }
//            case "passengerSearchCar": {
//                //将其加入搜寻队列
//                Integer pid = JSONObject.parseObject(data).getInteger("pid");
//                log.info("开始为乘客{}寻找附近车辆",pid);
//                orderWithStartPoss.put(pid, (OrderWithStartPos) redisTemplate.opsForValue().get(PASSENGER_SEARCH_QUEUE+pid));
//                break;
//            }
//            //将searchRide交给服务器进行，完成后发送信息给前端
//            case "cancelOrder": {
//                Integer pid = JSONObject.parseObject(data).getInteger("pid");
//                log.info("用户{}停止寻找车辆", pid);
////                closeSocket(pid);
//                orderWithStartPoss.remove(pid);
//                sessions.remove(pid);
//                redisTemplate.delete(PASSENGER_SEARCH_QUEUE + pid);
//                break;
//            }
//        }
//
//    }
//
//    public static void informPassenger(Integer pid, JSONObject message) {
//        try {
//            Session session = sessions.get(pid);
//            session.getBasicRemote().sendText(message.toString());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void closeSocket(Integer pid) {
//        try {
//            Session session = sessions.get(pid);
//            orderWithStartPoss.remove(pid);
//            sessions.remove(pid);
//            session.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}