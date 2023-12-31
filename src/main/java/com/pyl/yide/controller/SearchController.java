package com.pyl.yide.controller;

import com.pyl.yide.model.vo.SearchVO;
import com.pyl.yide.manager.SearchFacade;
import com.pyl.yide.common.BaseResponse;
import com.pyl.yide.common.ResultUtils;
import com.pyl.yide.model.dto.search.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/search")
public class SearchController {
   @Resource
   private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        SearchVO searchVO = searchFacade.searchAll(searchRequest, request);
        return ResultUtils.success(searchVO);
    }
}
