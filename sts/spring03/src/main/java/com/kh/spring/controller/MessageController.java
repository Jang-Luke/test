package com.kh.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.dto.Message;
import com.kh.spring.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	private MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/list")
	public String printList(Model model) throws SQLException {
		setList(model);
		return "/message/list";
	}

	@GetMapping("/register")
	public String toRegister() {
		return "/message/register";
	}
	
	@PostMapping("/register")
	public String register(Message message, Model model) throws SQLException {
		messageService.save(message);
		return "/home";
	}
	
	@GetMapping("/modify")
	public String toModify(Model model) throws SQLException {
		setList(model);
		return "/message/modify";
	}
	
	@PostMapping("/modify")
	public String modify(Message message, Model model) throws SQLException {
		Message modifiedmessage = messageService.modify(message);
		model.addAttribute("message", modifiedmessage);
		return "redirect:/message/list";
	}
	
	@GetMapping("/delete")
	public String toDelete(Model model) throws SQLException {
		setList(model);
		return "/message/delete";
	}
	
	@PostMapping("/delete")
	public String delete(Message message, Model model) throws SQLException{
		messageService.delete(message);
		return "redirect:/message/list";
	}
	
	private void setList(Model model) throws SQLException {
		List<Message> messageList = messageService.findAll();
		model.addAttribute("list", messageList);
	}
	
	@ExceptionHandler
	public String catchExceptions(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("exceptionType", e.getClass().toString());
		model.addAttribute("message", e.getMessage());
		return "/error";
	}
}
