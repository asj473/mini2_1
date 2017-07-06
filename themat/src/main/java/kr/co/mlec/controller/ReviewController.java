package kr.co.mlec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.service.ReviewService;
import kr.co.mlec.vo.ReviewVO;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/list.do")
	public ModelAndView listReview() throws Exception{
		List<ReviewVO> list = reviewService.listReview();
	
		ModelAndView mav = new ModelAndView("/review/listReview");
		mav.addObject("list", list);
		
		return mav;
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
