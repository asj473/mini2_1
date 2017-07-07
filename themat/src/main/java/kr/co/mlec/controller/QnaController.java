package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.service.QnaService;
import kr.co.mlec.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	

	@RequestMapping("/listForm.do")
	public void listForm(){}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> list() throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", qnaService.list());
		System.out.println(qnaService.list());
		return map;
		
	}
	
	@RequestMapping("/dtailForm.do")
	public void dtailForm(){}
	
	@RequestMapping("/dtail.do")
	@ResponseBody
	public Map<String, Object> dtail(int bno) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", qnaService.detail(bno));
		
		System.out.println("1 "+qnaService.detail(bno) );
		return map;
		
		
	}
	
	
	
	
}
