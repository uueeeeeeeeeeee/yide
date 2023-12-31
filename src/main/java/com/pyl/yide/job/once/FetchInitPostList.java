package com.pyl.yide.job.once;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.pyl.yide.model.entity.Post;
import com.pyl.yide.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 单次任务爬虫
 *

 */
// todo 取消注释开启任务
//@Component
@Slf4j
public class FetchInitPostList implements CommandLineRunner {

    @Resource
    private PostService postService;



    @Override
    public void run(String... args) {
        String json = "{\"sortField\":\"createTime\",\"sortOrder\":\"descend\",\"reviewStatus\":1,\"current\":1}";
        String result2 = HttpRequest
                .post("https://www.code-nav.cn/api/post/list/page/vo")
                .body(json)
                .execute().body();
        System.out.println(result2);

        //2、json转对象
        Map<String, Object> map = JSONUtil.toBean(result2, Map.class);
        System.out.println(map);
        JSONObject data = (JSONObject) map.get("data");
        JSONArray records = (JSONArray) data.get("records");

        ArrayList<Post> posts = new ArrayList<>();

        for (Object record : records) {
            JSONObject tempRecord = (JSONObject) record;
            Post post = new Post();
            post.setTitle(tempRecord.getStr("title"));
            post.setContent(tempRecord.getStr("content"));
            JSONArray tags = (JSONArray) tempRecord.get("tags");
            List<String> tag = tags.toList(String.class);
            post.setTags(JSONUtil.toJsonStr(tag));
            post.setUserId(1L);
            posts.add(post);
        }
//        System.out.println(posts);
        postService.saveBatch(posts);
    }
}
