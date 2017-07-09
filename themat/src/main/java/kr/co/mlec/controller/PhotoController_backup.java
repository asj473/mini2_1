/*package kr.co.mlec.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.mlec.service.PhotoService;
import kr.co.mlec.vo.PhotoFileVO;
import kr.co.mlec.vo.PhotoVO;

@Controller
@RequestMapping("/photo")
public class PhotoController_backup {

	@Autowired
	private PhotoService photoService;
	
	@Autowired  
	private ServletContext servletContext;
	
	
	
	
	@RequestMapping("/main.do")
	public void photoMain(){}
	
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> photoList(@RequestParam(value="pageNo", defaultValue="1") int pageNo) throws Exception {
		System.out.println("pageNO = " + pageNo);
		
//		ModelAndView mav = new ModelAndView("/photo/list");
//		mav.addObject("list", photoService.list());
//		return mav;
		
//		List<PhotoVO> list = photoService.list();
//		for(PhotoVO e: list){
//			System.out.println(e.getTitle());
//		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", photoService.list());
		
		return map;
	}
	
	
	
	
	
	
	@RequestMapping("/detail.do")
	@ResponseBody
	public Map<String, Object> detail(@RequestParam("no") int no) throws Exception {
		System.out.println("상세 게시물 번호 : " + no);
		Map<String, Object> result = photoService.detail(no);
		
		result.put("path", servletContext.getRealPath("/upload")); 
		
		return result;
	}
	
	
	
	
	
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(PhotoVO board, MultipartHttpServletRequest mRequest) throws Exception {
		
		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("board", board);
		
		// 파일 처리
		String uploadPath = servletContext.getRealPath("/upload");
		
		// upload 하위에 모듈별 날짜 형태의 디렉토리 생성후 저장
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		uploadPath += datePath;
		
		System.out.println(uploadPath);
		
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		Iterator<String> iter = mRequest.getFileNames(); // 파일을 업로드 하는 input테그의 name속성들을 반환한다
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName); // MultipartFile에 파일에 관련된 모든 정보가 담김
			// 사용자가 파일을 선택하지 않아도, 객체가 생김(?). 따라서 아래에서 null인지 구분해서 처리한다
			
			// 원본 파일명
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + oriFileName);
			
			if(oriFileName != null && !oriFileName.equals("")) {
				// 확장자 처리(예전에는 fileRename관련 외부 클래스로 처리함. 앞으로도 그렇게 해야함(BitRenamePolicy사용??))
				String ext = "";
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				long fileSize = mFile.getSize();
				System.out.println("파일 사이즈 : " + fileSize);
				
				// 고유한 파일명 만들기	
				String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				System.out.println("저장할 파일명 : " + saveFileName);
			
				
				
				
				PhotoFileVO boardFile = new PhotoFileVO();
				// boardFile.setNo(board.getNo());
				boardFile.setOriName(oriFileName);
				boardFile.setSystemName(saveFileName);
				boardFile.setFilePath(datePath);
				boardFile.setFileSize(fileSize);
				
				boardMap.put("boardFile", boardFile);
				
				
				
				// 임시저장된 파일을 원하는 경로에 저장(cos는 자동으로 저장하지만, 스프링은 지금처럼 직접 저장을 지정해 줘야 한다)
				mFile.transferTo(new File(uploadPath + "/" + saveFileName));
			} 
		} 
		photoService.write(boardMap);
		
		System.out.println("등록된 게시물 번호 : " + board.getNo());
		
		return "redirect:/photo/main.do";
	}
	

	@RequestMapping("/delete.do")
	public String photoDelete(@RequestParam("no") int no) throws Exception {
		System.out.println("삭제할 글번호 = " + no);
		photoService.delete(no);
		
		return "redirect:/photo/main.do";
	}
	
	
	
	
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public void update() throws Exception{
		
	}

	
	
}















*/