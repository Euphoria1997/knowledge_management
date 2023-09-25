package com.example.knowledge_managing.controller;


import com.example.knowledge_managing.common.CachedResult;
import com.example.knowledge_managing.common.DocumentResult;
import com.example.knowledge_managing.common.QueryInfo;

import com.example.knowledge_managing.mapper.DocumentMapper;
import com.example.knowledge_managing.service.*;
import com.example.knowledge_managing.util.RespCode;
import com.example.knowledge_managing.util.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wenwen
 * @since 2023 09 22
 */
@RestController
@RequestMapping("/knowledgeSearch")
@Slf4j
public class BasicQueryController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IDocumentService iDocumentService;
    @Autowired
    private DocumentMapper documentMapper;
    //  这个前缀对应在redis中保存用户查询内容，若与新的查询一致则可以进入缓存中查询
    private static final String user_query_cache = "user_query:";
    //  这个前缀对应在redis中保存用户查询结果，包括结果范围，查询list 前者用于判断是否可以从缓存中完整获得，后者用于返回结果
    private static final String user_query_result = "user_query_result:";


    private void query_database_and_set_cache(String userID, String query_key, Integer begin_query_index, Integer end_query_index, Integer cached_page) {
//        todo: 需写查询逻辑
//        todo: 需写统计逻辑
//        List<Object> query_result = null;
        List<DocumentResult> query_results = documentMapper.get_document_with_page_indexs(begin_query_index, end_query_index, query_key, userID);
        /**
         * private Integer begin_index;
         *     private Integer end_index;
         *     private List<DocumentResult> results;
         */


        CachedResult cachedResult = null;

        cachedResult.setBegin_index(begin_query_index);
        cachedResult.setEnd_index(end_query_index);
        cachedResult.setResults(query_results);
//  加入缓存
        redisTemplate.opsForValue().set(user_query_cache + userID, query_key, 10, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(user_query_result + userID, cachedResult, 10, TimeUnit.MINUTES);
        return;


    }

    private List<DocumentResult> get_query_result_from_cache(CachedResult cachedResult, Integer begin_index, Integer end_index) {
//      todo: 直接遍历效率可能更高
        List<DocumentResult> result = (List<DocumentResult>) cachedResult.getResults().stream().filter(item -> item.getIndex() >= begin_index && item.getIndex() < end_index);
        return result;
    }

    @PostMapping("/getDocument")
    public RespResult getDocument(@RequestBody QueryInfo queryInfo) {
//        用于在缓存中检索 其查询形式为 user——tag _ keywords
        String query_key = String.join("/", queryInfo.getUser_tags()) + "_" + String.join("/", queryInfo.getKeyword());
        Integer begin_query_index = queryInfo.getPageIndex() * queryInfo.getPageSize();
        Integer end_query_index = begin_query_index + queryInfo.getPageSize();
        String cached_query_key = (String) redisTemplate.opsForValue().get(user_query_cache + queryInfo.getUserID());
        List<DocumentResult> result = null;
        CachedResult cached_result = null;
        if (query_key.equals(cached_query_key)) {
//            todo:这一部分获得结果可能接口没用对需要修改
            cached_result = (CachedResult) redisTemplate.opsForValue().get(user_query_result + queryInfo.getUserID());
            if (cached_result != null) {
                if (begin_query_index < cached_result.getBegin_index() || end_query_index > cached_result.getEnd_index()) {
                    query_database_and_set_cache(queryInfo.getUserID(), query_key, begin_query_index, end_query_index, queryInfo.getCache_page());
                }
            }
        } else {
            query_database_and_set_cache(queryInfo.getUserID(), query_key, begin_query_index, end_query_index, queryInfo.getCache_page());
        }
//        最后统一在cache中获得结果
        if (cached_result == null) {
            cached_result = (CachedResult) redisTemplate.opsForValue().get(user_query_result + queryInfo.getUserID());
        }

        assert cached_result != null;
        result = get_query_result_from_cache(cached_result, begin_query_index, end_query_index);
        return RespResult.responseWithData(RespCode.SUCCESS, result);

    }

//    @PostMapping("/getRides")
//    public RespResult getRides(@RequestBody JSONObject jsonObject) {
//        //key获取与某乘客相关申诉
//        Integer rid = jsonObject.getInteger("rid");
//        Integer pageIndex = jsonObject.getInteger("pageIndex");
//        Integer pageSize = jsonObject.getInteger("pageSize");
//        List<HashMap<String, Object>> data = null;
//        if (rid != null) {
//            log.info("管理员查阅订单{}相关信息", rid);
//        }
//        Integer total = iRideService.getPageTotalbyRid(rid);
//        data = iRideService.getPageByRid(pageIndex, pageSize, rid);
//        log.info("申诉相关信息成功取得");
//        return RespResult.responseWithPageData(RespCode.SUCCESS, data, new RespPage(total, pageSize));
//    }
//
//
//    @PostMapping("/login")
//    public RespResult login(@RequestBody JSONObject jsonObject) {
//        Integer aid = jsonObject.getInteger("aid");
//        String password = jsonObject.getString("password");
//        log.info("管理用户登录");
//        Admin user = (Admin) redisTemplate.opsForValue().get("wenwen:admin:user:" + aid);
//        if (user == null) {
//            user = iAdminService.getById(aid);
//            if (user == null) {
//                log.info("用户不存在");
//                return RespResult.responseWithoutData(RespCode.ADMIN_LACK_INFO);
//            }
//        }
//        if (password.equals(user.getPassword())) {
//            redisTemplate.opsForValue().set("wenwen:admin:user:" + aid, user, 60, TimeUnit.MINUTES);
//            return RespResult.responseWithData(RespCode.SUCCESS, user);
//        } else {
//            log.info("管理用户登录密码错误");
//            return RespResult.responseWithoutData(RespCode.ADMIN_LOGIN_ERROR);
//        }
//    }
//
//    @PostMapping("/getPassengersList")
//    public RespResult getPassengersList(@RequestBody BasicQueryPage queryPage) {
//        Page<Passenger> producePage = new Page<Passenger>(queryPage.getPageIndex(), queryPage.getPageSize());
//        //todo mp的搜索可以用索引优化
//        Page<Passenger> page = iPassengerService.page(producePage, new QueryWrapper<Passenger>().like("pid", queryPage.getKey()).orderByDesc("create_time"));
//        List<Passenger> records = page.getRecords();
//        List<User> data = records.stream().map(UserInfoUtil::getSafeUser).toList();
//        return RespResult.responseWithPageData(RespCode.SUCCESS, data, new RespPage(page.getTotal(), page.getSize()));
//    }
//
//    @PostMapping("/getCouponsList")
//    public RespResult getCouponsList(@RequestBody BasicQueryPage queryPage) {
//        Page<Coupon> producePage = new Page<Coupon>(queryPage.getPageIndex(), queryPage.getPageSize());
//        //todo mp的搜索可以用索引优化
//        Page<Coupon> page = iCouponService.page(producePage, new QueryWrapper<Coupon>().like("cid", queryPage.getKey()).orderByDesc("create_time"));
//        List<Coupon> data = page.getRecords();
//        return RespResult.responseWithPageData(RespCode.SUCCESS, data, new RespPage(page.getTotal(), page.getSize()));
//    }
//
//    @PostMapping("/getDriverList")
//    public RespResult getDriverList(@RequestBody BasicQueryPage queryPage) {
//        Page<Driver> producePage = new Page<Driver>(queryPage.getPageIndex(), queryPage.getPageSize());
//        //todo mp的搜索可以用索引优化
//        Page<Driver> page = iDriverService.page(producePage, new QueryWrapper<Driver>().like("did", queryPage.getKey()).orderByDesc("create_time"));
//        List<Driver> records = page.getRecords();
//        List<User> data = records.stream().map(UserInfoUtil::getSafeUser).toList();
//        return RespResult.responseWithPageData(RespCode.SUCCESS, data, new RespPage(page.getTotal(), page.getSize()));
//    }
//
//
//    @PostMapping("/changeUserStatus")
//    public RespResult changeUserStatus(@RequestBody JSONObject jsonObject) {
//        Integer uKind = jsonObject.getInteger("uKind");
//        Integer id = jsonObject.getInteger("id");
//        log.info("{}{}改变状态", uKind == 0 ? "司机" : "乘客", id);
//        if (iAdminService.updateUserStatusByIdAndUserKind(id, uKind)) {
//            log.info("状态改变成功");
//            return RespResult.responseWithoutData(RespCode.SUCCESS);
//        }
//        log.error("状态改变失败");
//        return RespResult.responseWithoutData(RespCode.ADMIN_LACK_INFO);
//    }
//
//    @PostMapping("/changeComplaintStatus")
//    public RespResult changeComplaintStatus(@RequestBody JSONObject jsonObject) {
//        Integer newStatus = jsonObject.getInteger("newStatus");
//        Integer rid = jsonObject.getInteger("rid");
//        if (rid == null) {
//            return RespResult.responseWithoutData(RespCode.RID_NOT_RECIEVE);
//        }
//        //todo 给审核再加入一个状态从通过-》完结退款给用户
//        log.info("申诉订单{}状态改变为{}", rid, newStatus == 1 ? "通过" : "驳回");
//        if (iComplaintService.updateStatusByRid(rid, newStatus)) {
//            log.info("状态改变成功");
//            return RespResult.responseWithoutData(RespCode.SUCCESS);
//        }
//        log.error("状态改变失败");
//        return RespResult.responseWithoutData(RespCode.ADMIN_LACK_INFO);
//    }
//
//    @PostMapping("/changeCouponStatus")
//    public RespResult changeCouponStatus(@RequestBody JSONObject jsonObject) {
//        Integer cid = jsonObject.getInteger("cid");
//        log.info("优惠券{}停止贩卖", cid);
//        if (iCouponService.removeById(cid)) {
//            log.info("状态改变成功");
//            return RespResult.responseWithoutData(RespCode.SUCCESS);
//        }
//        log.error("状态改变失败");
//        return RespResult.responseWithoutData(RespCode.ADMIN_LACK_INFO);
//    }
//
//    @PostMapping("/pubCoupon")
//    public RespResult pubCoupon(@RequestBody Coupon coupon) {
//        log.info("新的优惠券创建");
//        if (iCouponService.save(coupon)) {
//
//            log.info("新的优惠券创建，其ID为{}", coupon.getCid());
//            return RespResult.responseWithoutData(RespCode.SUCCESS);
//        }
//        log.info("新的优惠券创建失败");
//        return RespResult.responseWithoutData(RespCode.ADMIN_EXIST_ERROR);
//    }
//
//    @PostMapping("/getAction")
//    public RespResult getAction(@RequestBody JSONObject jsonObject) {
//        LocalDate begin = jsonObject.getObject("begin", LocalDateTime.class).toLocalDate();
//        LocalDate end = jsonObject.getObject("end", LocalDateTime.class).toLocalDate();
//        log.info("管理员查询从{}至{}平台接单量",begin,end);
//        List<DailyRideNum> data = iDailyRideNumService.getDailyRideByBeginAndEnd(begin,end);
//        return RespResult.responseWithData(RespCode.SUCCESS, data);
//    }
//
//    @PostMapping("/getTopPopularPlace")
//    public RespResult getTopFivePopularPlace(@RequestBody JSONObject jsonObject) {
//        LocalDate begin = jsonObject.getObject("begin", LocalDateTime.class).toLocalDate();
//        LocalDate end = jsonObject.getObject("end", LocalDateTime.class).toLocalDate();
//        log.info("管理员查询从{}至{}平台最多到达的目的地",begin,end);
//        List<HashMap<String,Object>> data = iDailyRideNumService.getPopularPlace(begin,end);
//        return RespResult.responseWithData(RespCode.SUCCESS, data);
//    }
//
//    //获取横坐标为日期，纵坐标为小时分对应的散点图，用于观察订单量和时间的关系
//    @PostMapping("/getOrderTimeDataSet")
//    public RespResult getOrderTime(@RequestBody JSONObject jsonObject) {
//        LocalDate begin = jsonObject.getObject("begin", LocalDateTime.class).toLocalDate();
//        LocalDate end = jsonObject.getObject("end", LocalDateTime.class).toLocalDate();
//        log.info("管理员查询从{}至{}用户量随日期的变化",begin,end);
//        List<HashMap<String,Object>> data = iDailyRideNumService.getOrderTimeDataSet(begin,end);
//        return RespResult.responseWithData(RespCode.SUCCESS, data);
//    }

}
