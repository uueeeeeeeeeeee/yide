package com.pyl.yide.model.vo;

import com.pyl.yide.model.entity.Picture;
import lombok.Data;

import java.util.List;
@Data
public class SearchVO {
    private List<UserVO> UserList;
    private List<PostVO> PostList;
    private List<Picture> PictureList;
    private List<?> dataList;


}
