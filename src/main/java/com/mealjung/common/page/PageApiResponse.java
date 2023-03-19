package com.mealjung.common.page;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageApiResponse<T> {

    private final PageApiValue pageApiValue;
    private final List<T> contents;

    public PageApiResponse(Page<T> page) {
        this.pageApiValue = new PageApiValue(page);
        this.contents = page.getContent();
    }

    public static <T> PageApiResponse<T> create(Page<T> page) {
        return new PageApiResponse<>(page);
    }

}


