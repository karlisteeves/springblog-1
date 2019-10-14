package com.codeup.springblog.repos;

import com.codeup.springblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    long editById(long id);
}
