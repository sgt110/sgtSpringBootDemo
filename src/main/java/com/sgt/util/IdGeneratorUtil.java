package com.sgt.util;


import java.util.UUID;

/**
 * 业务id生成器
 *
 * @author lith
 * @version V1.0
 * @since 2021-12-18 16:49
 */
public class IdGeneratorUtil {




    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
