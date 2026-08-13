package com.sgt.enums;

/**
 * @author 孙官土
 * @description TODO
 * @date 2024/7/30 14:03
 */
public interface EnumInterface {

    String getCode();

    String getName();

    static String getNameByCode(String code, EnumInterface[] enumInterfaces) {
        for (EnumInterface enumInterface : enumInterfaces) {
            if (enumInterface.getCode().equals(code)) {
                return enumInterface.getName();
            }
        }
        return null;
    }

    static String getCodeByName(String name, EnumInterface[] enumInterfaces) {
        for (EnumInterface enumInterface : enumInterfaces) {
            if (enumInterface.getName().equals(name)) {
                return enumInterface.getCode();
            }
        }
        return null;
    }
}
