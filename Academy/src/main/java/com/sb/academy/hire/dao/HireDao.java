package com.sb.academy.hire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sb.academy.hire.model.HireVO;

public interface HireDao {

	// 총 게시글 수
	public int selectCount();

	// 게시글 불러오기
	public List<Object> selectList(int firstRow, int endRow);

	// 게시글 작성
	public void insert(HireVO hireVO);

	// 게시글 삭제
	public void delete(@Param("boardArray") List<Object> boardArray);
}
