package com.wzx.it.employeeservice.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.EmployeeInfoRepository;
import com.wzx.it.employeeservice.utils.LocalDateTimeUtils;
import lombok.Synchronized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class EmployeeCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCache.class);

    private static final String EMPLOYEE = "employee";

//    private static Map<Integer, EmployeeInfo> employeeInfoMap = new HashMap<>();

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    @Qualifier("redisTemplateUtil")
    private RedisTemplate<Object, Object> redisTemplate;
//    @Autowired private StringRedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    // 通过CacheBuilder构建一个缓存实例
    private static final Cache<Integer, EmployeeInfo> employeeInfoMap = CacheBuilder.newBuilder()
            .maximumSize(10000) // 设置缓存的最大容量
            .expireAfterAccess(3, TimeUnit.MINUTES) // 设置缓存在写入一分钟后失效
            .concurrencyLevel(10) // 设置并发级别为10
            .recordStats() // 开启缓存统计
            .build();


    /**
     * 同步数据
     */
    @Synchronized
    public void syncEmployee() {
        List<EmployeeInfo> employeeInfos = employeeInfoRepository.findAll();
        employeeInfos.forEach(item->{
            employeeInfoMap.put(item.getId(),item);
            redisTemplate.boundHashOps(EMPLOYEE).put(item.getId(),item);
            if (!mongoTemplate.collectionExists(EMPLOYEE)) {
                mongoTemplate.createCollection(EMPLOYEE);
                mongoTemplate.indexOps(EMPLOYEE);
            }
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(item.getId()));

            Update update = new Update();
            update.set("name", item.getName());
            mongoTemplate.upsert(query, update, EmployeeInfo.class, EMPLOYEE);
        });
    }

    //    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        LOGGER.info("定时任务启动时间：" + LocalDateTimeUtils.formatDateTime(LocalDateTime.now()));
        List<EmployeeInfo> employeeInfos = employeeInfoRepository.findAll();
        for (int i = 0; i < employeeInfos.size(); i++) {
            EmployeeInfo employeeInfo = employeeInfos.get(i);
//            redisTemplate.boundHashOps(EMPLOYEE).put(employeeInfo.getId().toString(),JSONObject.toJSONString(employeeInfo));
//            if (!mongoTemplate.collectionExists(EMPLOYEE)) {
//                mongoTemplate.createCollection(EMPLOYEE);
//                mongoTemplate.indexOps(EMPLOYEE);
//            }
//            mongoTemplate.insert(employeeInfo, EMPLOYEE);
        }
    }

    public List<EmployeeInfo> getAllEmployeesByCache() {
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        if (employeeInfoMap.size() == 0) {
            employeeInfos = employeeInfoRepository.findAll();
        } else {
            employeeInfos.addAll(employeeInfoMap.asMap().entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        }
        return employeeInfos;
    }

    public EmployeeInfo getEmployeesByCache(Integer empId) throws ExecutionException {
        EmployeeInfo employeeInfo = employeeInfoMap.getIfPresent(empId);
        if (employeeInfo == null) {
            EmployeeInfo result = employeeInfoRepository.findEmployeeInfoById(empId);
            employeeInfoMap.put(empId,result);
            return result;
        }
        return employeeInfo;
    }
}
