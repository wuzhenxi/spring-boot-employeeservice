package com.wzx.it.employeeservice.java8;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    @Test
    public void case_test1() {
        String result = "[{'featureID':'uuid0001','itemId':'142357'},{'featureID':'uuid0001','itemId':'142358'},{'featureID':'uuid0001','itemId':'142359'}]";
        JSONArray jsonArray = JSONArray.parseArray(result);
        List<Integer> itemId = jsonArray.stream().map(data -> JSONObject.parseObject(JSONObject.toJSONString(data)).getInteger("itemId")).collect(Collectors.toList());
        itemId.stream().forEach(System.out::println);

    }

    @Test
    public void case_test2() {
        String result = "[{'featureID':'uuid0001','itemId':'142357'},{'featureID':'uuid0002','itemId':'142358'},{'featureID':'uuid0003','itemId':'142359'}]";
        JSONArray jsonArray = JSONArray.parseArray(result);
        Map<Integer, String> itemForFeature = jsonArray.stream().collect(Collectors.toMap((obj) -> JSONObject.parseObject(obj.toString()).getInteger("itemId"), (obj) -> JSONObject.parseObject(obj.toString()).getString("featureID")));
        itemForFeature.forEach((key, value)-> System.out.println("key:"+key+",value:"+value));


        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        itemForFeature.entrySet().stream().forEach(item->{
            System.out.println("key:"+item.getKey()+",value:"+item.getValue());
        });
    }
}
