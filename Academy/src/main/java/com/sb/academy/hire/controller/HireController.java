package com.sb.academy.hire.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sb.academy.hire.model.HireVO;
import com.sb.academy.hire.service.HireService;
import com.sb.academy.home.model.PageListView;
import com.sb.academy.home.service.UploadService;

@Controller
public class HireController {

	@Autowired
	HireService service;

	@Autowired
	UploadService fileService;

	// 페이지 이동
	@RequestMapping(value = "/hire/{page}", method = RequestMethod.GET)
	public ModelAndView notified(@PathVariable("foldername") String page) {

		ModelAndView modelAndView = new ModelAndView("/hire/" + page);

		return modelAndView;
	}

	// loadList ajax로 불러오기
	@RequestMapping(value = "/hire/notify/loadList", method = RequestMethod.GET)
	public ModelAndView loadList(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "rowNum", defaultValue = "3") int rowNum) {

		// 수동으로 입력한 객체의 페이지 갯수
		int count_per_page = rowNum * 4;

		ModelAndView modelAndView = new ModelAndView();

		// loadReturnList.jsp 에 넣을 객체를 받아온다.
		PageListView viewData = service.getList(pageNumber, count_per_page);

		modelAndView.addObject("viewData", viewData);

		modelAndView.setViewName("/hire/notify/loadList");

		return modelAndView;
	}

	// 글쓰기 페이지 이동
	@RequestMapping(value = "/hire/notify/write", method = RequestMethod.GET)
	public ModelAndView write() {

		ModelAndView modelAndView = new ModelAndView("/hire/notify/write");

		return modelAndView;
	}

	// 파일 업로드 및 게시글 올리기
	@RequestMapping(value = "/hire/notify/write", method = RequestMethod.POST)
	public ModelAndView boardWrite(HireVO hireVO, HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {

		// 글 작성 후 notify 페이지로 다시 이동
		ModelAndView modelAndView = new ModelAndView("/hire/notify");

		// 파일을 서버에 업로드 및 저장된 파일 경로 구하기
		String photo = fileService.imgUpload(hireVO.getFile(), request, response);
		
		// hireVO에 파일 경로 입력
		hireVO.setPhoto(photo);
		
		// 글쓰기
		service.boardWrite(hireVO);

		return modelAndView;
	}

}
