package com.example.app.service;

import java.util.List;

import com.example.app.domain.Reserve;

public interface ReserveService {
	
	
	List<Reserve> getReserveList();

	Reserve selectByReserveId(Integer id);

	void addReserve(Reserve reserve);

	void editReserve(Reserve reserve);

	void deleteReserve(Integer id);

	List<Reserve> getReserveListByPage(int page, int numPerPage);

	int getTotalPages(int numPerPage);

}
