package com.mealjung.common.converter.utils;

import com.mealjung.common.enums.EnumType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.EnumSet;
import java.util.NoSuchElementException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumConverterUtils {
    public static <T extends Enum<T> & EnumType> T ofEnum(Class<T> enumClass, String value) {
        if (!StringUtils.hasText(value)) {
            return null;
        }

        return EnumSet.allOf(enumClass).stream()
                .filter(v->v.getValue().equals(value))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("%s : Value [%s]가 존재하지 않습니다.", enumClass.getSimpleName(), value)));
    }

    public static <T extends Enum<T> & EnumType> T ofValue(Class<T> enumClass, String code) {
        if (!StringUtils.hasText(code)) {
            return null;
        }

        return EnumSet.allOf(enumClass).stream()
                .filter(v->v.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("%s : Code [%s]가 존재하지 않습니다.", enumClass.getSimpleName(), code)));
    }

    public static <T extends Enum<T> & EnumType> String toCode(T enumValue) {
        if (enumValue == null) {
            return "";
        }
        return enumValue.getCode();
    }

}


