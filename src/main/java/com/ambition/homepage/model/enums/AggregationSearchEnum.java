package com.ambition.homepage.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 聚合搜索类型枚举
 *
 * @author ambition
 */
public enum AggregationSearchEnum {

    SKILL("技能专长", "1"),
    COMPANY("公司项目", "2"),
    PERSONAL("个人项目", "3");

    private final String text;

    private final String value;

    AggregationSearchEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return 值列表
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value value
     * @return 枚举
     */
    public static AggregationSearchEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (AggregationSearchEnum anEnum : AggregationSearchEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
