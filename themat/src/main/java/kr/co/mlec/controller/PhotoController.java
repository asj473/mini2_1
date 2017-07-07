package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.service.PhotoService;
import kr.co.mlec.vo.PhotoVO;

@Controller
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	
	@RequestMapping("/main.do")
	public void photoMain(){
	}
	
	
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
//		Map<String, Object> result = photoService.detail(no);
		
//		mav.addObject("board", result.get("board"));
//		mav.addObject("file", result.get("file"));
		
		return photoService.detail(no);
	}
	
	
	
	
	
	@RequestMapping("/regist.do")
	public void photoRegist(){
		
	}

	
	@RequestMapping("/registForm.do")
	public void photoRegistForm(){
		
	}
	
	@RequestMapping("/update.do")
	public void photoUpdate(){
		
	}

	
	@RequestMapping("/updateForm.do")
	public void photoUpdateForm(){
		
	}
	
	
	@RequestMapping("/delete.do")
	public void photoDelete(){
		
	}
	
	
}















