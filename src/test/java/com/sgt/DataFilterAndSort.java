package com.sgt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DataFilterAndSort {
    public static void main(String[] args) {
        // �ṩ�� JSON ����
        String json = "[{\"logicOper\":\"0\",\"firstRelationOper\":\"2\",\"secondRelationOper\":\"\",\"firstValue\":\"100\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"debitamount\",\"sort\":\"\",\"operType\":\"0\",\"sortNum\":\"\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"2\",\"secondRelationOper\":\"\",\"firstValue\":\"200\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditamount\",\"sort\":\"\",\"operType\":\"0\",\"sortNum\":\"\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"\",\"secondRelationOper\":\"\",\"firstValue\":\"\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditamount\",\"sort\":\"0\",\"operType\":\"1\",\"sortNum\":\"1\"}," +
                "{\"logicOper\":\"0\",\"firstRelationOper\":\"\",\"secondRelationOper\":\"\",\"firstValue\":\"\",\"secondValue\":\"\",\"filterValues\":\"\",\"operCode\":\"creditaccumamount\",\"sort\":\"1\",\"operType\":\"1\",\"sortNum\":\"2\"}]";
//        String json = "";

        // ���� JSON ����
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

        // ת��Ϊ FilterCondition �����б�
        List<FilterCondition> filterConditions = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            FilterCondition condition = gson.fromJson(jsonObject, FilterCondition.class);
            filterConditions.add(condition);
        }

        // ԭʼ����
        List<JsonElement> data = new ArrayList<>();
        data.add(gson.fromJson("{\"debitamount\":102,\"creditamount\":\"400\",\"creditaccumamount\":\"10\"}", JsonElement.class));
        data.add(gson.fromJson("{\"debitamount\":150,\"creditamount\":\"450\",\"creditaccumamount\":\"5\"}", JsonElement.class));
        data.add(gson.fromJson("{\"debitamount\":101,\"creditamount\":\"400\",\"creditaccumamount\":\"6\"}", JsonElement.class));

        // ����ɸѡ������������ɸѡ
        List<JsonElement> filteredData = filterData(data, filterConditions);
        System.out.println("Filtered Data:");
        for (JsonElement element : filteredData) {
            System.out.println(element.getAsJsonObject());
        }

        // ����������������������
        List<JsonElement> sortedData = sortData(filteredData, filterConditions);
        System.out.println("Sorted Data:");
        for (JsonElement element : sortedData) {
            System.out.println(element);
        }
    }

    // ɸѡ����
    private static List<JsonElement> filterData(List<JsonElement> data, List<FilterCondition> filterConditions) {
        List<JsonElement> filteredData = new ArrayList<>();
        for (JsonElement element : data) {
            boolean matchesAllConditions = true;
            for (FilterCondition condition : filterConditions) {
                if (!condition.matches(element)) {
                    matchesAllConditions = false;
                    break;
                }
            }
            if (matchesAllConditions) {
                filteredData.add(element);
            }
        }
        return filteredData;
    }

    // ��������
    private static List<JsonElement> sortData(List<JsonElement> data, List<FilterCondition> filterConditions) {
        Collections.sort(data, new Comparator<JsonElement>() {
            @Override
            public int compare(JsonElement element1, JsonElement element2) {
                for (FilterCondition condition : filterConditions) {
                    int result = condition.compare(element1, element2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        });
        return data;
    }

    // ɸѡ������
    private static class FilterCondition {
        private String logicOper;
        private String firstRelationOper;
        private String secondRelationOper;
        private String firstValue;
        private String secondValue;
        private String filterValues;
        private String operCode;
        private String sort;
        private String operType;
        private String sortNum;

        public boolean matches(JsonElement element) {
            JsonObject jsonObject = element.getAsJsonObject();
            String value = jsonObject.get(operCode).getAsString();

            if (firstRelationOper.isEmpty() && secondRelationOper.isEmpty()){
                return true;
            } else if (firstRelationOper.isEmpty() || firstValue.isEmpty()) {
                // �����һ������Ϊ�գ�����Ե�һ��������ֻ���ǵڶ�������
                return checkCondition(secondRelationOper, secondValue, value);
            } else if (secondRelationOper.isEmpty() || secondValue.isEmpty()) {
                // ����ڶ�������Ϊ�գ���ֻ���ǵ�һ������
                return checkCondition(firstRelationOper, firstValue, value);
            } else {
                // ����ͬʱ�������������������߼����������ж�
                if (logicOper.equals("0")) {
                    // �����
                    return checkCondition(firstRelationOper, firstValue, value) && checkCondition(secondRelationOper, secondValue, value);
                } else if (logicOper.equals("1")) {
                    // �����
                    return checkCondition(firstRelationOper, firstValue, value) || checkCondition(secondRelationOper, secondValue, value);
                }
            }

            return false;
        }

        private boolean checkCondition(String relationOper, String targetValue, String actualValue) {
            switch (relationOper) {
                case "0": // ����
                    return actualValue.equals(targetValue);
                case "1": // ������
                    return !actualValue.equals(targetValue);
                case "2": // ����
                    return Double.parseDouble(actualValue) > Double.parseDouble(targetValue);
                case "3": // ���ڵ���
                    return Double.parseDouble(actualValue) >= Double.parseDouble(targetValue);
                case "4": // С��
                    return Double.parseDouble(actualValue) < Double.parseDouble(targetValue);
                case "5": // С�ڵ���
                    return Double.parseDouble(actualValue) <= Double.parseDouble(targetValue);
                default:
                    return false;
            }
        }

        public int compare(JsonElement element1, JsonElement element2) {
            JsonObject jsonObject1 = element1.getAsJsonObject();
            JsonObject jsonObject2 = element2.getAsJsonObject();
            String value1 = jsonObject1.get(operCode).getAsString();
            String value2 = jsonObject2.get(operCode).getAsString();

            if (sort.equals("0")) {
                // ˳������
                return compareValues(value1, value2);
            } else if (sort.equals("1")) {
                // ��������
                return compareValues(value2, value1);
            }

            return 0;
        }

        private int compareValues(String value1, String value2) {
            if (value1.isEmpty() || value2.isEmpty()) {
                return 0;
            }

            double doubleValue1 = Double.parseDouble(value1);
            double doubleValue2 = Double.parseDouble(value2);

            if (doubleValue1 > doubleValue2) {
                return 1;
            } else if (doubleValue1 < doubleValue2) {
                return -1;
            }

            return 0;
        }
    }
}
