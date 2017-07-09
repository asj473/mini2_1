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
	
	//리스트 
	@RequestMapping("/listForm.do")
	public void listForm(){}
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("list", qnaService.list());
		System.out.println("리스트 ajax 실행");
		return map;
	}
	
	//디테일
	@RequestMapping("/dtailForm.do")
	public void dtailForm(){}
	@RequestMapping("/dtail.do")
	@ResponseBody
	public Map<String, Object> dtail(int bno) throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("list", qnaService.detail(bno));
		return map;
	}
	
	//삭제
	@RequestMapping("/delete.do")
	@ResponseBody
	public void delete(int bno) throws Exception{
		System.out.println("삭제 컨트롤 들어옴");
		qnaService.delete(bno);
	}
	
	//글쓰기 write.do
	@RequestMapping("/write.do")
	public String delete(QnaVO qnavo) throws Exception{
		System.out.println("글쓰기 컨트롤 들어옴");
		qnaService.write(qnavo);
		return "redirect:/qna/listForm.do";
	}
	//수정하기 
	@RequestMapping("/update.do")
	public String update(QnaVO qnavo) throws Exception{
		System.out.println("업데이트 컨트롤 들어옴");
		System.out.println(qnavo.getContent());
		qnaService.update(qnavo);
		return "redirect:/qna/listForm.do";
	}
	
	
	
}
