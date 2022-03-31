package com.kmg733.org.study.web.dto;

import com.kmg733.org.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        // 빌더를 통한 생성자 만들기
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
