package com.sgt.enums;

/**
 * @author 孙官土
 * @description TODO
 * @date 2024/7/30 13:38
 */
public enum TestEnum implements EnumInterface{
    A("a", "1"),
    B("b", "2");

    private String name;
    private String code;

    TestEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

}
