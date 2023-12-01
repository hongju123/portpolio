package com.portpolio.controller.ocoController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.portpolio.domain.dto.ocoDto.AllListDTO;
import com.portpolio.domain.dto.ocoDto.BusinessDTO;
import com.portpolio.domain.dto.ocoDto.BusinessInfoDTO;
import com.portpolio.domain.dto.ocoDto.Criteria;
import com.portpolio.domain.dto.ocoDto.ReplyDTO;
import com.portpolio.domain.dto.ocoDto.ReplyPageDTO;
import com.portpolio.service.ocoService.FindListService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/Bboard/*")
@Controller
public class OcoBboardController {
	@Autowired
	private FindListService service;

	@GetMapping("getlist")
	public String getlist() {
		return "ocoProject/Bboard/listindex.html";
	}

	// 찾아보기 리스트 가져오기
	@ResponseBody
	@GetMapping(value = "findlist", consumes = "application/json")
	public ResponseEntity<AllListDTO> findlist(@RequestParam String main, @RequestParam String city, Model model) {

		if (main.toString().contains("전체")) {
			main = "";
		}
		if (!city.contains("/")) {
			city = "";

		}

		return new ResponseEntity<AllListDTO>(service.getMainList(main, city), HttpStatus.OK);
	}

	// 맵 가져오기
	@GetMapping("findmap")
	public String getmap(String main, String city, Model model) {
		model.addAttribute("main", main);
		model.addAttribute("city", city);
		return "ocoProject/Bboard/findmap.html";
	}

	// 아이디로 번호값 가져오기
	@GetMapping("getpage")
	public String getpage(String businessId) {
		Long businessIdx = service.getIndexNum(businessId);
		return "redirect:/Bboard/get?businessIdx=" + businessIdx;
	}

	// 사업자 소개 페이지 구별
	@GetMapping(value = { "get", "modify" })
	public String get(@RequestParam("businessIdx") Long businessIdx, HttpServletRequest req, Model model) {
		Long businessInfoIdx = businessIdx;
		BusinessDTO userboard = service.userDetail(businessIdx);
		BusinessInfoDTO infoboard = service.infoDetail(businessIdx);
		model.addAttribute("userboard", userboard);
		model.addAttribute("infoboard", infoboard);
		model.addAttribute("files", service.getFileList(businessInfoIdx));
		model.addAttribute("profiles", service.getprofile(businessInfoIdx));
		System.out.println(service.getprofile(businessInfoIdx).size());
		String requsetURI = req.getRequestURI();

		return "ocoProject"+requsetURI;
	}

	// 사업자 수정 페이지
	@PostMapping("modify")
	public String modifyOk(BusinessInfoDTO info, HttpServletRequest req, MultipartFile[] files,
			MultipartFile[] profiles, String profileCnt, String updateCnt) throws Exception {
		service.profilemodify(profiles, info, profileCnt);
		// 시간대
		String open = req.getParameter("maa1") + " " + req.getParameter("open_time");
		String close = req.getParameter("maa2") + " " + req.getParameter("close_time");
		String Time = open + " ~ " + close;
		info.setUseTime(Time);
		// 파일관련
		if (service.modify(info, files, updateCnt)) {
			return "redirect:/Bboard/get?businessIdx=" + info.getBusinessInfoIdx();
		} else {
			return null;
		}
	}

	@GetMapping("thumbnail")
	public ResponseEntity<Resource> thumbnail(String systemName) throws Exception {
		return service.getThumbnailResource(systemName);
	}

	@GetMapping("profile")
	public ResponseEntity<Resource> profile(String systemName) throws Exception {
		return service.getThumbnailResourceProfile(systemName);
	}

	// 리뷰
	@ResponseBody
	@PostMapping(value = "insertReply", consumes = "application/json;charset=utf-8")
	public ResponseEntity<String> insertReply(@RequestBody ReplyDTO reply) {
		Long businessInfoIdx = reply.getBoardNum();
		boolean check = (service.riplyRegist(reply) && service.visit(businessInfoIdx));
		Long replynum = service.getLastNum(reply.getUserId());
		double allGrade = service.totalGrade(businessInfoIdx);
		service.setallGrade(allGrade, businessInfoIdx);
		return check ? new ResponseEntity<String>(replynum + "", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseBody
	@GetMapping(value = "replyPages")
	public ResponseEntity<ReplyPageDTO> getList(@RequestParam("boardNum") Long boardNum,
			@RequestParam("pagenum") int pagenum) {
		Criteria cri = new Criteria(pagenum, 5);
		return new ResponseEntity<ReplyPageDTO>(service.getList(cri, boardNum), HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("deletereply")
	public ResponseEntity<String> remove(@RequestParam("replynum") Long replynum,
			@RequestParam("businessInfoIdx") Long businessInfoIdx) {
		if (service.remove(replynum) && service.removeInfo(businessInfoIdx)) {
			double allGrade = service.totalGrade(businessInfoIdx);
			service.setallGrade(allGrade, businessInfoIdx);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ResponseBody
	@PostMapping(value = "replyUpdate", consumes = "application/json;charset=utf-8")
	public ResponseEntity<String> modify(@RequestBody ReplyDTO reply) {
		service.replyModify(reply);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

}
