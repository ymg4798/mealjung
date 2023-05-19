package com.mealjung.common.converter;

import com.mealjung.common.converter.utils.AbstractEnumAttributeConverter;
import com.mealjung.common.enums.FavoriteType;

import javax.persistence.Converter;

@Converter
public class FavoriteTypeConverter extends AbstractEnumAttributeConverter<FavoriteType> {
    public static final String enumName = "FavoriteType";

    public FavoriteTypeConverter() {
        super(FavoriteType.class, false, enumName);
    }
}
