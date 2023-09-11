package com.example.hello;

import com.alibaba.excel.EasyExcel;
import com.example.entity.ShopDict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 超大量excel读取测试类
 * @Author lisha 2023-06-16 09:55:28
 */
@Slf4j
public class ExcelTest {

    @Test
    public void simpleRead() {
        String fileName ="D:\\excel" + File.separator + "shop_dict.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ShopDict.class, new DemoDataListener()).sheet().doRead();
    }

    @Test
    public void simpleWrite() {
        // 定义要写入的Excel文件路径
        String filePath = "C:\\Users\\test.xlsx";

        // 定义表头，即第一行数据
        List<String> headList = Arrays.asList("姓名", "年龄", "性别");

        // 定义数据列表，即内容部分数据
        List<User> dataList = new ArrayList<>();
        dataList.add(new User("张三", 18, "男"));
        dataList.add(new User("李四", 22, "女"));

        // 调用EasyExcel的方法，将表头和数据写入到Excel文件中
//        EasyExcel.write(filePath, User.class).head(headList).sheet("Sheet1").doWrite(dataList);
    }


    @Data
    @AllArgsConstructor
    class User{
        private String name;
        private Integer age;
        private String sex;

    }
}
