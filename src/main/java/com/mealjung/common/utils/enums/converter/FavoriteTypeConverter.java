package com.mealjung.common.utils.enums.converter;

import com.mealjung.common.utils.enums.FavoriteType;

import javax.persistence.Converter;

@Converter
public class FavoriteTypeConverter extends AbstractEnumAttributeConverter<FavoriteType> {
    public static final String enumName = "FavoriteType";

    public FavoriteTypeConverter() {
        super(FavoriteType.class, false, enumName);
    }
}
