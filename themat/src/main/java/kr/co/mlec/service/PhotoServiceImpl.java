package kr.co.mlec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.PhotoMapper;
import kr.co.mlec.vo.PageResultVO;
import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.PhotoFileVO;
import kr.co.mlec.vo.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoMapper mapper;
	
	@Override
	public Map<String, Object> list(PageVO page) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("list", mapper.selectBoard(page));
		//map.put("pageResult", mapper.selectBoardCount(page));
		map.put("pageResult", new PageResultVO(page.getPageNo(), mapper.selectBoardCount(page)));
		System.out.println(map.get("pageResult"));
		return map;
	}

	@Override
	public Map<String, Object> detail(int no) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		result.put("board", mapper.selectBoardByNo(no));
		result.put("file", mapper.selectBoardFileByNo(no));
		
		return result;
	}

	@Override
	public void write(Map<String, Object> boardMap) throws Exception {
		PhotoVO board = (PhotoVO)boardMap.get("board");
		mapper.insertBoard(board);

		if(boardMap.get("boardFile") != null){
			PhotoFileVO boardFile = (PhotoFileVO)boardMap.get("boardFile");
			boardFile.setNo(board.getNo());
			
			mapper.insertBoardFile(boardFile);
		}
	}

	@Override
	public void delete(int no) throws Exception {
		mapper.deleteBoard(no);
		mapper.deleteFile(no);
	}

	@Override
	public void update(Map<String, Object> boardMap) throws Exception {
		PhotoVO board = (PhotoVO)boardMap.get("board");
		mapper.updateBoard(board);

		if(boardMap.get("boardFile") != null){
			PhotoFileVO boardFile = (PhotoFileVO)boardMap.get("boardFile");
			boardFile.setNo(board.getNo());
			
			mapper.updateBoardFile(boardFile);
		}
	}


	
	
}














