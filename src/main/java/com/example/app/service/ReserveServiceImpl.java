package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Reserve;
import com.example.app.mapper.ReserveMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ReserveServiceImpl implements ReserveService{

	private final ReserveMapper reserveMapper;

	@Override
	public List<Reserve> getReserveList() {
		return reserveMapper.findAll();
	}

	@Override
	public Reserve selectByReserveId(Integer id){
		return reserveMapper.selectByReserveId(id);
	}
	
	@Override
	public void addReserve(Reserve reserve){
		reserveMapper.insert(reserve);
	}

	@Override
	public void editReserve(Reserve reserve) {
		reserveMapper.update(reserve);
	}
	

	@Override
	public void deleteReserve(Integer id) {
		reserveMapper.delete(id);
	}
	

	@Override
	public List<Reserve> getReserveListByPage(int page, int numPerPage){
		int offset= (page - 1) * numPerPage;
	    return reserveMapper.selectLimited(offset, numPerPage);
	}
	
	@Override
	public int getTotalPages(int numPerPage) {
	    return reserveMapper.totalPages(numPerPage);
	}

}
