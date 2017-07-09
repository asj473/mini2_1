package kr.co.mlec.service;

import java.util.List;
import java.util.Map;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.PhotoVO;

public interface PhotoService {
	public Map<String, Object> list(PageVO page) throws Exception;
	public Map<String, Object> detail(int no) throws Exception;
	public void write(Map<String, Object> boardMap) throws Exception;
	public void delete(int no) throws Exception;
	public void update(Map<String, Object> boardMap) throws Exception;
	
}
