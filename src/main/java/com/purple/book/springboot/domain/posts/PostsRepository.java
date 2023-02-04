package com.purple.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // <Entity Class, PK Type> 상속으로 @Repository를 추가할 필요없이 crud 메소드 자동생성

}
