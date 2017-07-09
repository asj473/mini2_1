package kr.co.mlec.vo;

public class PageVO {
	private int pageNo = 1;

	// 한페이지에 보여지는 첫번째 값과
	public int getBegin() {
		return (pageNo -1) * 10 + 1;
	}
	
	// 마지막값 
	public int getEnd() {
		return pageNo * 10;
	}
	
	// -> list조회해서 쭉 나열하면 페이지마다 짜르기 위해
	// 		저기 10은 한 페이지마다 보여질 게시물 갯수
	// 		한 페이지에 보여줄 게시물 갯수만큼 정해주면돼 (동적으로 하려면 이 값도 매개변수로 받아와서)
	// 1페이지에 1-10, 2페이지에 11-20,....
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
