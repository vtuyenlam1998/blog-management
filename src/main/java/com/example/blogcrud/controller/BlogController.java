package com.example.blogcrud.controller;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ModelAndView showAllBlogs() {
        ModelAndView modelAndView = new ModelAndView("homepage");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs",blogList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showBlogDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        Blog blog = new Blog();
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Blog blog = blogService.delete(id);
        modelAndView.setViewName("redirect:/homepage");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs",blogList);
        modelAndView.addObject("message",blog);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewBlog(@ModelAttribute CreateBlogRequestDTO requestDTO ) {
        ModelAndView modelAndView = new ModelAndView("create");
        Blog blog = blogService.save(requestDTO);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
}
