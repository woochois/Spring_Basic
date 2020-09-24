package com.ch.ch06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/color")
	public String color(Model model) { // 컨트롤러에서 VIEW (JSP) 로 보내줄 모델
		String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "navy"};
		
		// 0 부터 6 까지의 정수를 랜덤하게 추
		int num = (int)(Math.random() * 7);
		model.addAttribute("color", color[num]);
		return "color";
	}
	
	@RequestMapping("/gugudan")
	public String gugudan(Model model) {
		// 2 - 9
		int num = (int)(Math.random() * 8) + 2;
		model.addAttribute("num", num);
		return "gugudan";
	}	
}
