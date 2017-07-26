package com.spring.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyExampleController {
	@RequestMapping("saveResult")
	@ResponseBody
	public String authorInfo(Model model){
		return "saved";
	}
}
