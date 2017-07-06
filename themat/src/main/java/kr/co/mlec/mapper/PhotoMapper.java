package kr.co.mlec.mapper;

import java.util.List;

import kr.co.mlec.vo.PhotoVO;

public interface PhotoMapper {

	public List<PhotoVO> selectBoard() throws Exception;
	
}
