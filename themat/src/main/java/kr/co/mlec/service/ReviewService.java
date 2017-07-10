package kr.co.mlec.service;

import java.util.List;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.ReviewVO;
import kr.co.mlec.vo.StoreVO;

public interface ReviewService {
	public ReviewVO detailReview(int no) throws Exception;
	public void registReview(ReviewVO review) throws Exception;
	public void updateReview(ReviewVO review) throws Exception;
	public void deleteReview(int no) throws Exception;

	public List<ReviewVO> listReview(int no, PageVO page) throws Exception;
	public int reviewCount(int no) throws Exception;
	
	public List<StoreVO> listStore(String category, PageVO page) throws Exception;
	public int storeCount(String category) throws Exception;
	
	public StoreVO detailStore(int no) throws Exception;
}
