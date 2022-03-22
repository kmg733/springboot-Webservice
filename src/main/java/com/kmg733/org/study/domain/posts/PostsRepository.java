package com.kmg733.org.study.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JPA에서 사용하는 DAO
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
