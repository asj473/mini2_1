package kr.co.mlec.service;

import java.util.List;
import java.util.Map;

import kr.co.mlec.vo.PhotoVO;

public interface PhotoService {
	public List<PhotoVO> list() throws Exception;
	public Map<String, Object> detail(int no) throws Exception;
	
	
}
