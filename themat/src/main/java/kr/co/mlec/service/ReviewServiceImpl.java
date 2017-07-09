package kr.co.mlec.service;

import java.util.List;

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
	public List<ReviewVO> listReview(int no) throws Exception {
		List<ReviewVO> list = reviewMapper.listReview(no);
		
		return list;
	}

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
	public List<StoreVO> listStore(PageVO page) throws Exception {
//		List<StoreVO> list = reviewMapper.listStore(page);
		
		return reviewMapper.listStore(page);
	}

	@Override
	public int storeCount(PageVO page) throws Exception {
//		int count = reviewMapper.storeCount(page);
		
		return reviewMapper.storeCount(page);
	}

}
