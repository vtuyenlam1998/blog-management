package com.example.blogcrud.controller;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.pageable.MyBatisPageable;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.payload.request.EditBlogRequestDTO;
import com.example.blogcrud.payload.response.PageResponseDTO;
import com.example.blogcrud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

//    @GetMapping
//    public ModelAndView showAllBlogs() {
//        ModelAndView modelAndView = new ModelAndView("homepage");
//        List<Blog> blogList = blogService.findAll();
//        modelAndView.addObject("blogs",blogList);
//        return modelAndView;
//    }
    @GetMapping
    public ModelAndView showAllBlogs(@RequestParam(name = "page",required = false,defaultValue = "0") Integer page,
                                     @RequestParam(name = "size",required = false,defaultValue = "5") Integer size
                                     ) {
        MyBatisPageable pageable = new MyBatisPageable(page,size);
        ModelAndView modelAndView = new ModelAndView("homepage");
        PageResponseDTO blogs = blogService.findByPage(pageable);
        modelAndView.addObject("blogs",blogs);
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

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        Blog blog = blogService.delete(id);
        modelAndView.setViewName("redirect:/blog");
        redirectAttributes.addFlashAttribute("message","Delete blog successfully");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewBlog(@ModelAttribute CreateBlogRequestDTO requestDTO, RedirectAttributes redirectAttributes ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        blogService.save(requestDTO);
        redirectAttributes.addFlashAttribute("message","New blog has been created successfully!");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute EditBlogRequestDTO requestDTO, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        redirectAttributes.addFlashAttribute("message","Blog has been edited successfully!");
        blogService.update(requestDTO);
        return modelAndView;
    }
}
