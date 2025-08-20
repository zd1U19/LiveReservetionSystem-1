package com.example.app.service;

import java.util.List;

import com.example.app.domain.Live;

public interface LiveService {
	

		List<Live> getLiveList();

		Live getLiveById(Integer id);

		void addLive(Live live);

		void editLive(Live live);

		void deleteLive(Integer id);

		List<Live> getLiveListByPage(int page, int numPerPage);

		int getTotalPages(int numPerPage);
		

	}


