package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Live;

public interface LiveMapper {

	List<Live> findAll();

	Live selectByLiveId(@Param("liveId")Integer liveId);

	public void insert(Live live);

	public void update(Live live);

	public void delete(Integer id);

	List<Live> selectLimited(@Param("offset") int offset,
			@Param("limit") int limit);

	public int totalPages(int numPerPage);

}
