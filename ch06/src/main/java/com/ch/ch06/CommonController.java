package com.ch.ch06;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonController {
	@ExceptionHandler(Exception.class)
	public ModelAndView err(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ex", e);
		mav.setViewName("common_error");
		return mav;
	}
}
