package com.nsp.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController 
{
	@RequestMapping(value = "index")
	public void index_jsp(Model model)
	{
		model.addAttribute("nsp", "宁思平您好!");
		System.out.println("index.jsp");
	}
}
