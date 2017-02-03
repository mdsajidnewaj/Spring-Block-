package sam.springframework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


import sam.springframework.models.Post;
import sam.springframework.services.PostService;


@Controller 
public class HomeController {
@Autowired
private PostService postService;
@RequestMapping("/")
public String index(Model model) {
List<Post> latest5Posts = postService.findLatest5();
model.addAttribute("latest5posts", latest5Posts);
List<Post> latest3Posts = latest5Posts.stream()
.limit(3).collect(Collectors.toList());
model.addAttribute("latest3posts", latest3Posts);
return "index";
}
}