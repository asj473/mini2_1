package kr.co.mlec.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, Object> detail(int no) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		result.put("board", mapper.selectBoardByNo(no));
//		result.put("file", mapper.selectBoardFileByNo(no));
		
		return result;
	}
	
}













