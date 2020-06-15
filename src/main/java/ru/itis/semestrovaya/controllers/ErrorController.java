package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semestrovaya.helper.HandledErrorsCounterBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @Autowired
    HandledErrorsCounterBean handledErrorsCounterBean;

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        handledErrorsCounterBean.handleNewError();
        System.out.println("Count of current errors handled: " + handledErrorsCounterBean.getCounterOfHandledErrors() + " for session with id: " + request.getSession().getId());

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        ModelAndView modelAndView = new ModelAndView("error");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            modelAndView.addObject("statusCode", statusCode);
        }
        return modelAndView;
    }
}
