package kr.co.mlec.mapper;

import java.util.List;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.PhotoFileVO;
import kr.co.mlec.vo.PhotoVO;

public interface PhotoMapper {
	public List<PhotoVO> selectBoard(PageVO page) throws Exception;
	public int selectBoardCount(PageVO search) throws Exception;

	public PhotoVO selectBoardByNo(int no) throws Exception;
	public void insertBoard(PhotoVO board) throws Exception;
	public void insertBoardFile(PhotoFileVO photoFile) throws Exception;
	public PhotoFileVO selectBoardFileByNo(int no) throws Exception;
	public void deleteBoard(int no) throws Exception;
	public void deleteFile(int no) throws Exception;
	public void updateBoard(PhotoVO board) throws Exception;
	public void updateBoardFile(PhotoFileVO photoFile) throws Exception;
	
	
}
