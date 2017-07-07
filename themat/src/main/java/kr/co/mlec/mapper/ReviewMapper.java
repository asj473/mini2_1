package kr.co.mlec.mapper;


import java.util.List;

import kr.co.mlec.vo.ReviewVO;
import kr.co.mlec.vo.StoreVO;


public interface ReviewMapper {
	public List<ReviewVO> listReview(int no) throws Exception;
	public ReviewVO detailReview(int no) throws Exception;
	public void registReview(ReviewVO review) throws Exception;
	public void updateReview(ReviewVO review) throws Exception;
	public void deleteReview(int no) throws Exception;
	
	public List<StoreVO> listStore() throws Exception;
	public StoreVO detailStore(int no) throws Exception;
}
