package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String listPosts(ModelMap modelmap){
    List<Post> posts = postRepository.getAllPosts();
        modelmap.put("title", "Blog Post 1");
        modelmap.put("posts", posts);


        return "home";
    }

}
