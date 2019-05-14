package com.sb.academy.hire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sb.academy.hire.service.HireService;
import com.sb.academy.home.model.PageListView;

@Controller
public class HireController {

	@RequestMapping(value = "/hire/notify", method = RequestMethod.GET)
	public ModelAndView notified() {

		ModelAndView modelAndView = new ModelAndView("/hire/notify");

		return modelAndView;
	}

//	static final int COUNT_PER_PAGE = 12;

	@Autowired
	HireService service;

	// loadList ajax
	@RequestMapping(value = "/hire/notify/loadList", method = RequestMethod.GET)
	public ModelAndView loadList(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "rowNum", defaultValue = "3") int rowNum) {
		
		//수동으로 입력한 객체의 페이지 갯수
		int count_per_page = rowNum * 4;

		ModelAndView modelAndView = new ModelAndView();

		// loadReturnList.jsp 에 넣을 객체를 받아온다.
		PageListView viewData = service.getList(pageNumber, count_per_page);

		modelAndView.addObject("viewData", viewData);

		modelAndView.setViewName("/hire/notify/loadList");

		return modelAndView;
	}

}
