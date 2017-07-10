package kr.co.mlec.mapper;


import java.util.List;
import java.util.Map;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.ReviewVO;
import kr.co.mlec.vo.StoreVO;


public interface ReviewMapper {
	public ReviewVO detailReview(int no) throws Exception;
	public void registReview(ReviewVO review) throws Exception;
	public void updateReview(ReviewVO review) throws Exception;
	public void deleteReview(int no) throws Exception;
	
	public List<ReviewVO> listReview(Map param) throws Exception;
	public int reviewCount(int no) throws Exception;
	
	public List<StoreVO> listStore(Map param) throws Exception;
	public int storeCount(String category) throws Exception;
	
	public StoreVO detailStore(int no) throws Exception;
}
