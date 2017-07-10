package kr.co.mlec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.MemberMapper;
import kr.co.mlec.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	
	
	@Override
	public MemberVO login(MemberVO member) throws Exception {
		return mapper.loginCheck(member);
	}
	
	
}














