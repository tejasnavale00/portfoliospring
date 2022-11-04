package com.tejasnavale.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tejasnavale.mail.Mail;
import com.tejasnavale.obj.Contactobj;

@Controller
public class MyWebController {
	
	@Autowired
	Mail mail;
	
	
	private int contactotp;

	@GetMapping("/")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		return mv;
	}
	
	
	@GetMapping("/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("about");

		return mv;
	}
	
	@GetMapping("/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("contact");

		return mv;
	}
	
	
	@PostMapping("/contact")
	public ModelAndView contactform(HttpServletRequest request ,@RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String message ) {

		ModelAndView mv = new ModelAndView();
		
		Contactobj cont=new Contactobj(); 
		
		mv.addObject("name", name);
		mv.addObject("email", email);
		mv.addObject("subject", subject);
		mv.addObject("message", message);
		
		
		Random rnd = new Random();
		int otp = rnd.nextInt(999999);
		System.out.println("Random number: "+ otp);
		
		this.contactotp=otp;
		
		mail.contactotp(name, email, otp);

		mv.setViewName("contactotp");

		return mv;
	}
	
	
	@PostMapping("/contactconfirm")
	public ModelAndView contactconfirm(HttpServletRequest request ,@RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String message, @RequestParam int otp ) {

		ModelAndView mv = new ModelAndView();
		
		Contactobj cont=new Contactobj(); 
		
		mv.addObject("name", name);
		mv.addObject("email", email);
		mv.addObject("subject", subject);
		mv.addObject("message", message);
		
		System.out.println("Random number: "+ this.contactotp);
		if(this.contactotp==otp)
		{
		mail.contactsubmit(name, email, subject, message);
		mv.setViewName("messagesent");
		}
		else
		{
		mv.setViewName("messagefail");
		}
		
		return mv;
	}
	
	
	
	@GetMapping("/privacypolicy")
	public ModelAndView privacypolicy() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("privacypolicy");

		return mv;
	}
	
}
