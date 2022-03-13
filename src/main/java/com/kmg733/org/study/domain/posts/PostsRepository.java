package com.kmg733.org.study.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA에서 사용하는 DAO
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
