package com.info.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MyController {
   
	 @RequestMapping(method=RequestMethod.GET)
	 public String callMe(ModelMap map){
		 map.addAttribute("greeting", "Hello World..");
		return "welcome";
		 
       }
	 
	 @RequestMapping(value="/againcall",method=RequestMethod.GET)
	 public String againCall(ModelMap map){
		 
		 map.addAttribute("greeting", "called again..");
		return "welcome";
		 
	 }
	 
}
