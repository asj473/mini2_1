package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.service.ReviewService;
import kr.co.mlec.vo.PageResultVO;
import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.ReviewVO;
import kr.co.mlec.vo.StoreVO;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/listStore.do")
	@ResponseBody
	public Map<String, Object> listStore(PageVO page) throws Exception{
		List<StoreVO> list = reviewService.listStore(page);
		int count = reviewService.storeCount(page);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("pageResult", new PageResultVO(page.getPageNo(), count));
		
		return map;
	}
	
	@RequestMapping("/listReview.do")
	@ResponseBody
	public Map<String, Object> listReview(int no) throws Exception{
		List<ReviewVO> list = reviewService.listReview(no);
		StoreVO store = reviewService.detailStore(no);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("store", store);
		
		return map;
	}
	
	@RequestMapping("/detail.do")
	public void detailReview(int no) throws Exception{
		reviewService.detailReview(no);
	}
	
	
	@RequestMapping("/regist.do")
	public void registReview(ReviewVO review) throws Exception{
		reviewService.registReview(review);
	}
	
	@RequestMapping("/update.do")
	public void updateReview(ReviewVO review) throws Exception{
		reviewService.updateReview(review);
	}
	
	
	@RequestMapping("/delete.do")
	public void deleteReview() throws Exception{
		
	}
	
	
}
