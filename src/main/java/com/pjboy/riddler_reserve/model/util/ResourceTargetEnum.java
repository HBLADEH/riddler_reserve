package com.pjboy.riddler_reserve.model.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public enum ResourceTargetEnum {
    GOODS(1);

    private final Integer key;

    ResourceTargetEnum(int key) {
        this.key = key;
    }

    public Integer getValue() {
        return key;
    }

    public static ResourceTargetEnum getResourceTargetEnumByValue(Integer value) {
        for (ResourceTargetEnum target : ResourceTargetEnum.values()) {
            if (Objects.equals(value, target.getValue())) return target;
        }
        return null;
    }
}
