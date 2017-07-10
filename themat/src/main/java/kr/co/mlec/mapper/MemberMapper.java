package kr.co.mlec.mapper;


import kr.co.mlec.vo.MemberVO;

public interface MemberMapper {
//	public List<PhotoVO> selectBoard(PageVO page) throws Exception;
	public MemberVO loginCheck(MemberVO member) throws Exception;
	
}
