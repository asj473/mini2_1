package kr.co.mlec.service;

import java.util.List;

import kr.co.mlec.vo.ReviewVO;

public interface ReviewService {
	public List<ReviewVO> listReview() throws Exception;
	public ReviewVO detailReview(int no) throws Exception;
	public void registReview(ReviewVO review) throws Exception;
	public void updateReview(ReviewVO review) throws Exception;
	public void deleteReview(int no) throws Exception;
}
