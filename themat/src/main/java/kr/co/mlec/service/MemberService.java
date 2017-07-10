package kr.co.mlec.service;

import kr.co.mlec.vo.MemberVO;

public interface MemberService {
//	public Map<String, Object> list(PageVO page) throws Exception;
	public MemberVO login(MemberVO member) throws Exception;
}
