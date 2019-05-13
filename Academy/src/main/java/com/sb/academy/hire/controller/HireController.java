package com.sb.academy.hire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HireController {

	@RequestMapping(value = "/hire/notify", method = RequestMethod.GET)
	public ModelAndView notified() {

		ModelAndView modelAndView = new ModelAndView("/hire/notify");

//		modelAndView.addObject("adminCalendar", "active");

		return modelAndView;
	}

}
