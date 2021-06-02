package com.Rioa.service;

import com.Rioa.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable,Blog blog);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog Blog);
    void deleteBlog(Long id);

}
