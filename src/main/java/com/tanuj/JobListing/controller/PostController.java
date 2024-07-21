package com.tanuj.JobListing.controller;

import com.tanuj.JobListing.model.JobPost;
import com.tanuj.JobListing.repository.PostRepository;
import com.tanuj.JobListing.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){

        return repository.findAll();

    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text){

        return searchRepository.findByText(text);

    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post){

        return repository.save(post);
    }
}
