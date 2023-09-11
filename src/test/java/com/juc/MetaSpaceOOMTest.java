package com.juc;

import net.bytebuddy.build.ToStringPlugin;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
  * @desc
  * @author 2023/9/6 0006 10:46 lisha
  */
public class MetaSpaceOOMTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true){
                System.out.println("----------");
                i++;
                Enhancer enhance = new Enhancer();
                enhance.setSuperclass(OOMTest.class);
                enhance.setUseCache(false);
                enhance.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhance.create();
            }
        } catch (Exception e) {
            System.out.println("****i=" + i);
            throw new RuntimeException(e);
        }
    }

    static class OOMTest{

    }

    /**
     * Error occurred during initialization of VM
     * MaxMetaspaceSize is too small.
     *
     * Exception in thread "main" java.lang.RuntimeException: net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
     * 	at com.juc.MetaSpaceOOMTest.main(MetaSpaceOOMTest.java:34)
     */

}

