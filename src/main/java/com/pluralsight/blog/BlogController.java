package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.model.Post;
import java.util.List;

@Controller
public class BlogController {
private PostRepository postRepository;

public BlogController(PostRepository postRepository){
    this.postRepository = postRepository;
}

      @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
    List<Post> posts = postRepository.getAllPosts();
    modelMap.put("title", "Blog Post 1");
    modelMap.put("posts", posts);
        return "home";
    }
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap ){

    Post post = postRepository.findById(id);
    modelMap.put("post", post);
    return "post-details";

    }

}
