package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();

        posts.add(new Post("Post 1 Title", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium, ad aliquam aspernatur, consequuntur harum inventore laboriosam, libero magni quia quidem ratione sequi sit. Aspernatur magni mollitia nam nemo nihil perspiciatis quaerat quasi. Cupiditate deserunt doloremque doloribus ea enim explicabo facilis ipsa magnam maiores molestiae molestias omnis possimus, ratione totam!\n"));
        posts.add(new Post("Post 2 Title", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium, ad aliquam aspernatur, consequuntur harum inventore laboriosam, libero magni quia quidem ratione sequi sit. Aspernatur magni mollitia nam nemo nihil perspiciatis quaerat " +
                "quasi. Cupiditate deserunt doloremque doloribus ea enim explicabo facilis ipsa magnam maiores molestiae molestias omnis possimus, ratione totam!\n"));

        model.addAttribute(posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsById(@PathVariable int id, Model model) {
        Post post = new Post("Individual Post 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium, ad aliquam aspernatur, consequuntur harum inventore laboriosam, libero magni quia quidem ratione sequi sit. Aspernatur magni mollitia nam nemo nihil perspiciatis quaerat quasi. Cupiditate deserunt doloremque doloribus ea enim explicabo facilis ipsa magnam maiores molestiae molestias omnis possimus, ratione totam!\n");

        model.addAttribute(post);

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
