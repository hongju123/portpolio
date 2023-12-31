package com.portpolio.controller.ocoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portpolio.domain.dto.ocoDto.BoardDTO;
import com.portpolio.service.ocoService.BoardService;
import com.portpolio.service.ocoService.ReservationService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OcoFrontController {
	@Autowired
	ReservationService reService;
	@Autowired
	private BoardService cservice;

	@GetMapping("/ocoProject/index")
	public String index(HttpServletRequest req, Model model, Long amount, Long startRow) {
		if (req.getSession().getAttribute("loginUser") != null
				&& reService.getUser((String) req.getSession().getAttribute("loginUser")) != null) {

			String userId = (String) req.getSession().getAttribute("loginUser");
			System.out.println("현재 유저 아이디 : "+req.getSession().getAttribute("loginUser"));
			System.out.println("GetUser :" + reService.getUser(userId));
			model.addAttribute("list",reService.getUser((String)req.getSession().getAttribute("loginUser")));
		}
		amount = (amount != null && amount > 10L) ? amount : 10L;
		startRow = (startRow != null && startRow > 0L) ? startRow : 0L;
		log.info("startRow:{}", startRow);
		log.info("amount:{}", amount);
		List<BoardDTO> clist = cservice.getBoardAllList(amount,startRow);
		model.addAttribute("clist", clist);
		// System.out.println(req.getSession().getAttribute("loginUser"));
		return "ocoProject/index";
	}
	
}
