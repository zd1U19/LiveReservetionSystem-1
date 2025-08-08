package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Live;
import com.example.app.mapper.LiveMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class LiveServiceImpl implements LiveService {

	private final LiveMapper liveMapper;

	@Override
	public List<Live> getLiveList() {
		return liveMapper.findAll();
	}

	@Override
	public Live getLiveById(Integer id) {
		return liveMapper.selectByLiveId(id);
	}

	@Override
	public void addLive(Live live) {
		liveMapper.insert(live);
	}

	@Override
	public void editLive(Live live) {
		liveMapper.update(live);
	}

	@Override
	public void deleteLive(Integer id) {
		liveMapper.delete(id);
	}
	
	//以下理解しきってないので要確認
	
	@Override
	public List<Live> getLiveListByPage(int page, int numPerPage){
		int offset= (page - 1) * numPerPage;
	    return liveMapper.selectLimited(offset, numPerPage);
	}
	
	@Override
	public int getTotalPages(int numPerPage) {
	    return liveMapper.totalPages(numPerPage);
	}
}
