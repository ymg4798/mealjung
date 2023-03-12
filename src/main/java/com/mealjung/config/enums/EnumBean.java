package com.mealjung.config.enums;

import com.mealjung.common.utils.enums.EnumType;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
public class EnumBean {

    private Map<String, List<String>> factory = new LinkedHashMap<>();

    public void put(String key, Class<? extends EnumType> e) {
        factory.put(key, toValues(e));
    }

    private List<String> toValues(Class<? extends EnumType> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(EnumType::getValue)
                .collect(Collectors.toList());
    }

    public List<String> get(String key) {
        if(factory.get(key) == null){
            return new LinkedList<>();
        }
        return factory.get(key);
    }

    public Map<String, List<String>> get(List<String> keys) {
        if(keys == null || keys.size() == 0) {
            return new LinkedHashMap<>();
        }
        return keys.stream()
                .filter(key -> factory.get(key) != null)
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }

    public Map<String, List<String>> get(String... keys) {
        if(keys == null) {
            return new LinkedHashMap<>();
        }
        return Arrays.stream(keys)
                .filter(key -> factory.get(key) != null)
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }

    public Map<String, List<String>> getAll() { return factory;}
}
