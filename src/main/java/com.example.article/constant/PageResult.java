package com.example.article.constant;

import lombok.Data;

import java.util.List;

/**
 * @author Late-en
 */
@Data
public class PageResult<T> {
    private long total;
    private List<T> records;
}
