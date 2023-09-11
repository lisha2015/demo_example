package com.example.hello;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.entity.ShopDict;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 读取excel监听器
 * @Author lisha 2023-06-16 10:13:50
 */
public class DemoDataListener extends AnalysisEventListener<ShopDict> {

    private List<ShopDict> userList = new ArrayList<>();

    @Override
    public void invoke(ShopDict dict, AnalysisContext analysisContext) {
        System.out.println("当前行：" + analysisContext.readRowHolder().getRowIndex());
        System.out.println(dict.toString());

        userList.add(dict);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成，共读取到" + userList.size() + "条数据");
    }
}