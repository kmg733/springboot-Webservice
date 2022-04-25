package com.kmg733.org.study.web;

import com.kmg733.org.study.service.posts.PostsService;
import com.kmg733.org.study.web.dto.PostsResponseDto;
import com.kmg733.org.study.web.dto.PostsSaveRequestDto;
import com.kmg733.org.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestsDto) {
        return postsService.save(requestsDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestsDto) {
        return postsService.update(id, requestsDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
