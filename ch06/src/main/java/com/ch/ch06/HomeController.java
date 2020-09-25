package com.ch.ch06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@RequestMapping("gugu")
	public String gugu(Model model) {
		// 2 - 9
		int num = (int)(Math.random() * 8) + 2;
		model.addAttribute("num", num);
		return "gugu";
	}	
	
	@RequestMapping("guguForm")
	public String guguForm() {
		return "guguForm";
	}
	
	@RequestMapping("gugu2")
	public String gugu2(int num, Model model) {
		model.addAttribute("num", num);
		return "gugu";
	}
	
	@RequestMapping("memberForm")
	public String memberForm() {		
		return "memberForm";
	}
	
	@RequestMapping("member")
	public String member(String name, String tel, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("tel", tel);
		model.addAttribute("age", age);
		return "member";
	}
	
	// DTO를 만들면 통째로 받는다.
	@RequestMapping("member2")
	public String member2(Member member, Model model) {
		model.addAttribute("member", member);
		return "member2";
	}
	
	@RequestMapping("calForm")
	public String calForm() {
		return "calForm";
	}
	
	@RequestMapping("cal")
	public String cal(int num1, int num2, Model model) {
		model.addAttribute("plus", num1+num2);
		model.addAttribute("minus", num1-num2);
		model.addAttribute("multiply", num1*num2);
		model.addAttribute("divide", num1/num2);
		return "cal";
	}
	
//	// 현재의 컨트롤러에서 발생한 에러 처리
//	@ExceptionHandler(ArithmeticException.class)
//	public String err() {
//		return "err";
//	}
}
