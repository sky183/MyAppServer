package com.sb.academy.hire.dao;

import com.sb.academy.hire.model.HireVO;

public interface HireDao {
	
	public HireVO selectHireVO();
	
	public void insertHireVO(HireVO hireVO);
}
