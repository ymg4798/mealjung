package com.mealjung.common.page;

import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.Sort.Direction;

public class PageRequestApi {
    private int page = 1;
    private int size = 10;
    private Direction direction = Direction.DESC;

    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        int default_size = 10;
        int max_size = 50;
        this.size = size > max_size ? default_size : size;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page -1, size, Sort.by(direction, "regDate"));
    }

}


