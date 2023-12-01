package com.atguigu;

import lombok.Data;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;

public class CompareTest {
    public static void main(String[] args) {
        DataObj obj = new DataObj();
        if(obj.getType() != null){
            System.out.println(obj.getType() == 1);
        }
        if(obj.getValue() != null){
            System.out.println(BigDecimal.ZERO.compareTo(obj.getValue()));
        }

        BigDecimal price = new BigDecimal(2);
        obj.setValue(new BigDecimal(1));
        System.out.println(price.compareTo(obj.getValue()));

        System.out.println("程序结束");
    }
}

@Data
class DataObj{
    private Integer type;
    private BigDecimal value;
}
