package com.hrb.controller;

import com.hrb.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class DefaultRouteController {
    @Autowired
    private Address address;

    @Value("${a.url}")
    private String aUrl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUseragentJsp(Model model) {
        log.info("..\n HOME PAGE GET..\n");
        address.addToList(" From /");
        return "register-success";
    }

    //TODO : add RequestNullException class
    @ExceptionHandler(Exception.class)
    public ModelAndView handleRequestNullException(Exception e) {
        log.error("Exception : " + e.getMessage());
        return new ModelAndView("ErrorPage");
    }
}