package com.icrown.gameapi.commons.utils;

import org.springframework.stereotype.Component;

/**
 * @author Frank
 */
@Component
public class PageUtil {
    /**
     * 計算分頁頁數
     *
     * @param itemCount
     * @param pageSize
     * @return
     */
    public int getPageCount(int itemCount, int pageSize) {
        int pageCount = itemCount / pageSize;
        if (itemCount % pageSize != 0) {
            pageCount++;
        }
        return pageCount;
    }
}
