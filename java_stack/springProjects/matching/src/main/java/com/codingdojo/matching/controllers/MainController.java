package com.codingdojo.matching.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codingdojo.matching.form.DiscussionForm;
import com.codingdojo.matching.models.Discussion;
import com.codingdojo.matching.services.DiscussionService;
import com.codingdojo.matching.services.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscussionService discussionService;

    @RequestMapping({"/", "", "/home"})
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listGet(Model model, @ModelAttribute("discussionForm") DiscussionForm discussionForm, BindingResult bindingResult){
        Iterable<Discussion> discussions = discussionService.findall();


        model.addAttribute("discussions", discussions);
        model.addAttribute("discussionForm", discussionForm);
        return new ModelAndView("list");
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ModelAndView listPost(Model model, @ModelAttribute("discussionForm") DiscussionForm discussionForm, BindingResult bindingResult){

        // TODO:
        // Validate that post meets security concerns
        // Add post to DB
        System.out.println("Adding your post to DB: " + discussionForm.getTitle() + " " + discussionForm.getContent());
        Discussion discussionToSave = new Discussion();
        discussionToSave.setTitle(discussionForm.getTitle());
        discussionToSave.setContent(discussionForm.getContent());
        //TODO: resolve author from login service
        discussionToSave.setAuthor("Guest");
        discussionToSave.setDownvotes(0);
        discussionToSave.setUpvotes(0);
        discussionToSave.setTimestamp(new Date());

        discussionService.save(discussionToSave);

        // Query discussions after saving so that it shows up
        Iterable<Discussion> discussions = discussionService.findall();

        model.addAttribute("discussions", discussions);
        model.addAttribute("discussionForm", discussionForm);
        //model.addAttribute("message", "post");
        return new ModelAndView("list");
    }
}