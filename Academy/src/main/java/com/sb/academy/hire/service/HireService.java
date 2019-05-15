package com.sb.academy.hire.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sb.academy.hire.dao.HireDao;
import com.sb.academy.hire.model.HireVO;
import com.sb.academy.home.model.PageListView;

@Repository
public class HireService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private HireDao dao;

	// 게시글 불러오기
	@Transactional
	public PageListView getList(int pageNumber, int countPerPage) {
		
		// 전체 메시지 구하기
		// 메세지 갯수
		int objTotalCount = 0;

		// 표시할 페이지
		int currentPageNumber = pageNumber;

		// 메세지가 담길 리스트
		List<Object> objList = null;
		int firstRow = 0;
		int endRow = 0;
		
		dao = sessionTemplate.getMapper(HireDao.class);

		objTotalCount = dao.selectCount();

		// 메세지 갯수가 0보다 크면 첫 행에는 표시할 페이지 -1 * 10을 한다 - 이것은 표시할 행의 시작 인덱스다.
		// 마지막 행에는 표시할 페이지 갯수를 적는다.
		if (objTotalCount > 0) {
			firstRow = (pageNumber - 1) * countPerPage;
			endRow = countPerPage;
			// 현재 페이지에 표시할 메세지를 가져온다.
			objList = dao.selectList(firstRow, endRow);

		} else {
			currentPageNumber = 0;
			objList = Collections.emptyList();
		}

		return new PageListView(objList, objTotalCount, currentPageNumber, countPerPage, firstRow, endRow);
	}

	// 글쓰기
	@Transactional
	public void write(HireVO hireVO) {

		dao.insert(hireVO);

	}

	// 글 삭제
	@Transactional
	public void delete(List<Object> boardArray) {
		
		dao.delete(boardArray);

	}

}
