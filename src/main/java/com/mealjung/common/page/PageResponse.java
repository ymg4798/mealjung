package com.mealjung.common.page;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {

    private final PageValue pageValue;
    private final List<T> contents;

    public PageResponse(Page<T> page) {
        this.pageValue = new PageValue(page);
        this.contents = page.getContent();
    }

    public static <T> PageResponse<T> create(Page<T> page) {
        return new PageResponse<>(page);
    }

}


