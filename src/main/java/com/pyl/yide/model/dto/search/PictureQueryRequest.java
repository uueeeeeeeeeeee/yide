package com.pyl.yide.model.dto.search;

import com.pyl.yide.common.PageRequest;
import lombok.Data;

@Data
public class PictureQueryRequest extends PageRequest {
    /**
     * 搜索词
     */
    private String searchText;

}
