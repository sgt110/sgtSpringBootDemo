package com.sgt.service.abstracttest;

/**
 * @author 孙官土
 * @description TODO
 * @date 2024/7/10 9:55
 */
public class AbstractTestUtil {

    public static AbstractTest getAbstractTest(String name) {
        if ("extend1".equals(name)) {
            return new AbstractTestExtend1();
        }
        if ("extend2".equals(name)) {
            return new AbstractTestExtend2();
        }
        return null;
    }
}
