package kr.co.mlec.controller;

import java.util.ArrayList;
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
	
	
	
	
	@RequestMapping("/listMain.do")
	@ResponseBody
	public Map<String, Object> listMain() throws Exception{
		List<StoreVO> list1 = reviewService.listStore("한식", new PageVO()).subList(0, 3);
		List<StoreVO> list2 = reviewService.listStore("분식", new PageVO()).subList(0, 3);
		List<StoreVO> list3 = reviewService.listStore("일식/돈까스", new PageVO()).subList(0, 3);
		List<StoreVO> list4 = reviewService.listStore("중식", new PageVO()).subList(0, 3);
		List<StoreVO> list5 = reviewService.listStore("족발/보쌈", new PageVO()).subList(0, 3);
		List<StoreVO> list6 = reviewService.listStore("패스트푸드", new PageVO()).subList(0, 3);

		List<String> category = new ArrayList<>();
		category.add("한식");
		category.add("분식");
		category.add("일식/돈까스");
		category.add("중식");
		category.add("족발/보쌈");
		category.add("패스트푸드");
		
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		map.put("list4", list4);
		map.put("list5", list5);
		map.put("list6", list6);
		
		return map;
	}
	
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
