package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public Map<String, Object> listStore(String category, PageVO page) throws Exception{
		List<StoreVO> list = reviewService.listStore(category, page);
		int count = reviewService.storeCount(category);
		list.get(0).setRating(3);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("pageResult", new PageResultVO(page.getPageNo(), count));
		
		return map;
	}
	
	@RequestMapping("/listReview.do")
	@ResponseBody
	public Map<String, Object> listReview(int no, PageVO page) throws Exception{
		List<ReviewVO> list = reviewService.listReview(no, page);
		int count = reviewService.reviewCount(no);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("pageResult", new PageResultVO(page.getPageNo(), count));
		
		return map;
	}
	
	@RequestMapping("/detailStore.do")
	@ResponseBody
	public Map<String, Object> detailStore(int no) throws Exception{
		StoreVO store = reviewService.detailStore(no);
		
		Map<String, Object> map = new HashMap<>();
		map.put("store", store);
		
		return map;
	}
	
	@RequestMapping("/detail.do")
	public void detailReview(int no) throws Exception{
		reviewService.detailReview(no);
	}
	
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public String registReview(ReviewVO review) throws Exception{
		reviewService.registReview(review);
		
//		List<ReviewVO> list = reviewService.listReview(review.getStoreNo(), new PageVO());
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("list", list);
//		
//		return map;
		return "";
	}
	
	@RequestMapping("/update.do")
	public void updateReview(ReviewVO review) throws Exception{
		reviewService.updateReview(review);
	}
	
	
	@RequestMapping("/delete.do")
	public void deleteReview() throws Exception{
		
	}
	
	
}
