package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.service.QnaService;
import kr.co.mlec.vo.PageResultVO;
import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.QnaCommentVO;
import kr.co.mlec.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//리스트 
	@RequestMapping("/listForm.do")
	public void listForm(){}
	
//	@RequestMapping("/list.do")
//	@ResponseBody
//	public Map<String, Object> list() throws Exception{
//		Map<String, Object> map = new HashMap<>();
//		map.put("list", qnaService.list());
//		System.out.println("리스트 ajax 실행");
//		return map;
//	}
	// 리스트   페이징 
		@RequestMapping("/list.do")
		@ResponseBody
		public Map<String, Object> list(PageVO page) throws Exception{
			System.out.println(" 둘오옴66 ");
			System.out.println(page.getPageNo());
			System.out.println(page.getBegin());
			System.out.println(page.getEnd());
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", qnaService.list(page));
			map.put("pageResult", new PageResultVO(page.getPageNo(), qnaService.selectCount(page)));

			return map;
		}
	
	
	
	
	//디테일
	@RequestMapping("/dtailForm.do")
	public void dtailForm(){}
	@RequestMapping("/dtail.do")
	@ResponseBody
	public Map<String, Object> dtail(int bno) throws Exception{
		System.out.println("디테일 리스트 들어옴 ");
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
	
	//댓글 
	@RequestMapping("/commentList.do")
	@ResponseBody
	public List<QnaCommentVO> commentListAjax(int no) throws Exception {
		System.out.println("댓글 리스트 들어옴 ");
		return qnaService.commentList(no);
	}
	
	//댓글 등록 
	@RequestMapping("/commentRegist.do")
	@ResponseBody
	public List<QnaCommentVO> commentRegist(QnaCommentVO comment) throws Exception {
		return qnaService.commentRegist(comment);
	}
	
	//댓글 삭제 
	@RequestMapping("/commentDelete.do")
	@ResponseBody
	public List<QnaCommentVO> commentDeleteAjax(QnaCommentVO comment) throws Exception {
		System.out.println("코멘트 삭제 들어온 ");
		System.out.println(comment.getNo());
		return qnaService.commentDelete(comment);
	}
	
	//댓글 수정commentUpdate 
//	@RequestMapping("/board/commentUpdate.do")
//	@ResponseBody
//	public List<BoardComment> commentUpdateAjax(BoardComment comment) throws Exception {
//		return service.commentUpdate(comment);
//	}
	
	
}
