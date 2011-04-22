package com.aestas.blog.cloudfoundry.qa.mvc;

import com.aestas.blog.cloudfoundry.qa.data.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QatterController {

    @Autowired
    private final RedisRepository redis;

    @Autowired
    public QatterController(RedisRepository redis) {
        this.redis = redis;
    }

    @RequestMapping("/")
    public String root() {

        return noauth();
    }

    private String noauth() {
        return "home";
    }

    @RequestMapping(value = "/redisPut", method = RequestMethod.POST)
    public String post(WebPost post) {

        System.out.println(post.getName());
        try {
            this.redis.post(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/redisGet", method = RequestMethod.GET)
    public
    @ResponseBody
    String get(String name, HttpServletResponse response) {

        System.out.println("response name: " + name);
        response.setStatus(HttpServletResponse.SC_OK);

        return redis.getAsJson(name);
    }

    @RequestMapping("/dummy")
    public String dummy(Model model) {

        return "dummy";
    }


}
