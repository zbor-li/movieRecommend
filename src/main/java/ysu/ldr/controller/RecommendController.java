package ysu.ldr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ysu.ldr.service.RecommendationService;
import ysu.ldr.service.UserService;

@RestController
public class RecommendController {
    @Autowired
    private RecommendationService recommendationService;
    @Autowired
    private UserService userService;
    @DeleteMapping("/deleteRecommends/{userName}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteRecommends(@PathVariable("userName") String userName){
        Integer userId = userService.getUserByName(userName);
        return recommendationService.deleteRecommends(userId);
    }
}
