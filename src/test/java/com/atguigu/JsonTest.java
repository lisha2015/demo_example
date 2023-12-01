package com.atguigu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLOutput;

@Slf4j
public class JsonTest {
    public static void main(String[] args){

        JSONObject parent = new JSONObject();
        parent.put("a1", "a1");

        JSONObject son = new JSONObject();
        son.put("a", "a");
        son.put("b", "b");
        parent.put("son", son);

        System.out.println("改变前parent=" + parent.toJSONString());

        JSONObject son1 = new JSONObject(parent.getJSONObject("son"));
        // JSONObject son1 = JSON.parseObject(parent.getJSONObject("son").toJSONString());
        // JSONObject son1 = new JSONObject();
        // son1 = parent.getJSONObject("son");
        System.out.println(son1 == son);
        // son1.put("a", "A1");
        son1.remove("a");
        son.put("c", "c");
        System.out.println("改变后parent=" + parent.toJSONString());

        System.out.println("son=" + son);
        // System.out.println("son1=" + son1);


        System.err.println("aaaa");

    }
}
