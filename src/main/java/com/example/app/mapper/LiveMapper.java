package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Live;

public interface LiveMapper {

	List<Live> findAll();

	Live selectByLiveId(@Param("liveId")Integer liveId);
	
	void insert(Live live);

	void update(Live live);

	void delete(Integer id);

	//ページ分割機能
	List<Live> selectLimited(@Param("offset") int offset,
			@Param("limit") int limit);
	Long count();

	int totalPages(int numPerPage);

}
