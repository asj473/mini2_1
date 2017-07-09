package kr.co.mlec.vo;

public class PageResultVO {
	private int listSize = 9;
	private int tabSize = 5;
	private int pageNo;
	private int count;
	
	private int lastPage;
	private int beginPage;
	private int endPage;
	
	private boolean prev, next;
	
	public PageResultVO(int pageNo, int count){
		this.pageNo = pageNo;
		this.count = count;
		
		lastPage = (int)Math.ceil(count/(double)listSize);
		
		int currTab = (pageNo - 1) / tabSize + 1;
		this.beginPage = (currTab - 1) * tabSize + 1;
		this.endPage = (currTab * tabSize > lastPage) ? lastPage : currTab * tabSize;
		
		this.prev = beginPage != 1;
		this.next = endPage != lastPage;
	}

	
	
	// jsp가 꺼내서 쓸 수 있게 getter함수는 필요하다
	// 화면에 필요없는 것들은 gettet함수 안해도 된다 (필요할때)
	
	public int getPageNo() {
		return pageNo;
	}

	public int getCount() {
		return count;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean getPrev() {
		return prev;
	}

	public boolean getNext() {
		return next;
	}
	
	
	
}
