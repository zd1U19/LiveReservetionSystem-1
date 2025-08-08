package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Reserve;

public interface ReserveMapper {
	List<Reserve> findAll();

	Reserve selectByReserveId(@Param("reserveId") Integer reserveId);

	List<Reserve> findByLiveId(@Param("reserveId") Integer reserveId);

	void insert(Reserve reserve);

	void update(Reserve reserve);

	void delete(Integer id);

	List<Reserve> selectLimited(@Param("offset") int offset,
			@Param("limit") int limit);

	int totalPages(int numPerPage);

}
