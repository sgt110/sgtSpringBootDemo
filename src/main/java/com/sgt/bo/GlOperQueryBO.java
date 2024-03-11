package com.sgt.bo;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.text.Collator;
import java.util.Locale;
import java.util.Map;

public class GlOperQueryBO {

    /**
     * 操作类型，0，筛选 1排序
     */
    private Integer operType;

    /**
     * 逻辑操作类型，0：与 1：或
     */
    private Integer logicOper;

    /**
     * 第一个框大于小于这种 。0：等于，1：不等于，2：大于 3：大于等于 4：小于，5：小于等于
     */
    private String firstRelationOper;

    /**
     * 数值
     */
    private Double firstValue;

    /**
     * 0：等于，1：不等于，2：大于 3：大于等于 4：小于，5：小于等于
     */
    private String secondRelationOper;

    /**
     * 数值
     */
    private Double secondValue;

    /**
     * 筛选值
     */
    private String filterValues;

    /**
     * 操作字段
     */
    private String operCode;

    /**
     * 排序方向。0：顺序 1：倒序
     */
    private Integer sort;

    /**
     * 排序优先级（1为最大）
     */
    private Integer sortNum;

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Integer getLogicOper() {
        return logicOper;
    }

    public void setLogicOper(Integer logicOper) {
        this.logicOper = logicOper;
    }

    public String getFirstRelationOper() {
        return firstRelationOper;
    }

    public void setFirstRelationOper(String firstRelationOper) {
        this.firstRelationOper = firstRelationOper;
    }

    public Double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Double firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondRelationOper() {
        return secondRelationOper;
    }

    public void setSecondRelationOper(String secondRelationOper) {
        this.secondRelationOper = secondRelationOper;
    }

    public Double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Double secondValue) {
        this.secondValue = secondValue;
    }

    public String getFilterValues() {
        return filterValues;
    }

    public void setFilterValues(String filterValues) {
        this.filterValues = filterValues;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public GlOperQueryBO() {
    }
    

    /**
     * 排序字段为空，顺序或者倒序也没有，排序优先级也没有，说明不是排序的
     * @return
     */
    public boolean isSort(){
        return !StringUtils.isBlank(operCode) && sort != null && sortNum != null;
    }

}
