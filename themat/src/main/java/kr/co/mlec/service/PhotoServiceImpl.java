package kr.co.mlec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.PhotoMapper;
import kr.co.mlec.vo.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoMapper mapper;
	
	@Override
	public List<PhotoVO> list() throws Exception {
		return mapper.selectBoard();
	}
	
}
