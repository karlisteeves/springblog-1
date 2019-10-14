package com.codeup.springblog.controllers;

import com.codeup.springblog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsById(@PathVariable long id, Model model) {

        model.addAttribute("post", postDao.findById(id).orElse(null));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String postPost() {
        return "create a new post";
    }
}
