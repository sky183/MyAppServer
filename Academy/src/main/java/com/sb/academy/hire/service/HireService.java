package com.sb.academy.hire.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sb.academy.hire.model.HireVO;
import com.sb.academy.home.model.PageListView;

@Repository
public class HireService {

	// loadList.jsp에 값 전달
	@Transactional
	public PageListView getList(int pageNumber, int countPerPage) {
		
		//내가 임의로 설정한 갯수
		final int TOTAL = 34;
		
		//DB데이타 임의 생성
		List<Object> list = new ArrayList<>();
		
		for (int i = 1; i < TOTAL; i++) {
			list.add(new HireVO(i + ".png"));
		}
		

		// 전체 메시지 구하기
		// 메세지 갯수
		int objTotalCount = 0;

		// 표시할 페이지
		int currentPageNumber = pageNumber;

		// 메세지가 담길 리스트
		List<Object> objList = new ArrayList<Object>();
		int firstRow = 0;
		int endRow = 0;

		objTotalCount = TOTAL;

		// 메세지 갯수가 0보다 크면 첫 행에는 표시할 페이지 -1 * 10을 한다 - 이것은 표시할 행의 시작 인덱스다.
		// 마지막 행에는 표시할 페이지 갯수를 적는다.
		if (objTotalCount > 0) {
			firstRow = (pageNumber - 1) * countPerPage;
			endRow = firstRow + countPerPage;
			if (endRow >= list.size()) {
				endRow = list.size();
			}
			// 현재 페이지에 표시할 메세지를 가져온다.
			for (int i = firstRow; i < endRow; i++) {
				objList.add(list.get(i));
			}
			
			
		} else {
			currentPageNumber = 0;
			objList = Collections.emptyList();
		}

		return new PageListView(objList, objTotalCount, currentPageNumber, countPerPage, firstRow, endRow);
	}

}
