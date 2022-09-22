/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.sgt.bo;



import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 医保疾病对照批量导入BO
 *
 * @author wanglz
 * @version V1.0
 * @since 2020-07-02 15:27
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiseaseMedicareRelaImportBO {

    /**
     * 医保疾病编码
     */
    @NotBlank(message = "医保疾病编码不能为空")
    @ExcelProperty(value = "医保疾病编码(必填)", index = 0)
    private String medicareDiseaseCode;

    /**
     * 医保疾病名称
     */
    @NotBlank(message = "医保疾病名称不能为空")
    @ExcelProperty(value = "医保疾病名称(必填)")
    private String medicareDiseaseName;

    /**
     * 拼音码
     */
    @ExcelProperty(value = "拼音码(选填)")
    private String namePyAbbr;

    /**
     * 平台疾病编码
     */
    @NotBlank(message = "平台疾病编码不能为空")
    @ExcelProperty(value = "平台疾病编码(必填)")
    private String diseaseCode;

    /**
     * 平台疾病名称
     */
    @ExcelProperty(value = "自费金额")
    private String zfje;

    /**
     * 平台疾病名称
     */
    @ExcelProperty(value = "百分比")
    @NumberFormat("#.##%")
    private BigDecimal zfmc;

    /**
     * 平台疾病名称
     */
    @NotBlank(message = "平台疾病名称不能为空")
    @ExcelProperty(value = "平台疾病名称(必填)")
    private String diseaseName;



    public static Set<String> excludeColumnFiledNames() {
        Set<String> excludeColumnFiledNames = new HashSet<>();
        excludeColumnFiledNames.add("diseaseCode");
        return excludeColumnFiledNames;
    }


    public static Set<String> excludeColumnFiledNames2() {
        Set<String> excludeColumnFiledNames = new HashSet<>();
        excludeColumnFiledNames.add("namePyAbbr");
        excludeColumnFiledNames.add("diseaseCode");
        return excludeColumnFiledNames;
    }



}


