package com.mealjung.common.page;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@ToString
public class PageApiValue {
    private final int totalPage;
    private final int pageSize;
    private final int currentPage;
    private final long totalElements;

    public <T> PageApiValue(Page<T> page) {
        this.totalPage = page.getTotalPages();
        this.currentPage = setCurrentPage(page.getNumber());
        this.totalElements = page.getTotalElements();
        this.pageSize = page.getSize();
    }

    private int setCurrentPage(int num) {
        return num + 1;
    }

}



