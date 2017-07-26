package com.spring.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class OtherExampleController {
	@RequestMapping("other")
	public String requestResponesExample(HttpServletRequest request,
			HttpServletResponse response,Model model){
		model.addAttribute("attr", "attr of other");
		return "other";
	}
}
