package com.pyl.yide.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pyl.yide.model.entity.Picture;

public interface PictureService {
    /**
     * 搜索图片+爬虫
     * @param searchText
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}