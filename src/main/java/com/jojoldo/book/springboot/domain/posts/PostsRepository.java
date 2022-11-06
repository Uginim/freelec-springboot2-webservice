package com.jojoldo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    /*
        규모 있는 프로젝트에선 QueryDSL을 사용함
        1. 타입 안정성이 보장
        2. 국내 많은 회사들이 사용
        3. 레퍼런스가 많음
     */
}
