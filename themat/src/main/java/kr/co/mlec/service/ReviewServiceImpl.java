package kr.co.mlec.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.ReviewMapper;
import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.ReviewVO;
import kr.co.mlec.vo.StoreVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewMapper reviewMapper;
	

	@Override
	public ReviewVO detailReview(int no) throws Exception {
		ReviewVO review = reviewMapper.detailReview(no);
		return review;
	}

	@Override
	public void registReview(ReviewVO review) throws Exception {
		reviewMapper.registReview(review);
	}

	@Override
	public void updateReview(ReviewVO review) throws Exception {
		reviewMapper.updateReview(review);
	}

	@Override
	public void deleteReview(int no) throws Exception {
		reviewMapper.deleteReview(no);
	}

	@Override
	public StoreVO detailStore(int no) throws Exception {
//		StoreVO store = reviewMapper.detailStore(no);
		
		return reviewMapper.detailStore(no);
	}
	
	@Override
	public List<ReviewVO> listReview(int no, PageVO page) throws Exception {
//		List<ReviewVO> list = reviewMapper.listReview(no);
		Map<String, Object> param = new HashMap<>();
		param.put("page", page);
		param.put("storeNo", no);
		
		return reviewMapper.listReview(param);
	}

	@Override
	public List<StoreVO> listStore(String category, PageVO page) throws Exception {
//		List<StoreVO> list = reviewMapper.listStore(page);
		Map<String, Object> param = new HashMap<>();
		param.put("page", page);
		param.put("category", category);
		
		return reviewMapper.listStore(param);
	}

	@Override
	public int storeCount(String category) throws Exception {
//		int count = reviewMapper.storeCount(page);
		
		return reviewMapper.storeCount(category);
	}

	@Override
	public int reviewCount(int no) throws Exception {
		// TODO Auto-generated method stub
		return reviewMapper.reviewCount(no);
	}

}
