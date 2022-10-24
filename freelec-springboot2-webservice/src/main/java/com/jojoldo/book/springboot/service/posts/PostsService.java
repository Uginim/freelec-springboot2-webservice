package com.jojoldo.book.springboot.service.posts;


import com.jojoldo.book.springboot.domain.posts.Posts;
import com.jojoldo.book.springboot.domain.posts.PostsRepository;
import com.jojoldo.book.springboot.web.dto.PostsResponseDto;
import com.jojoldo.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent()); // 그냥 값만 바꿈... 따로 db에 update하는게없음
        // transaction이 끝나는 시점에 테이블의 변경분을 반영함


        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}

