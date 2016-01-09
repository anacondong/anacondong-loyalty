package com.loyalty.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loyalty.entity.User;
import com.loyalty.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;  
	
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public String userListHandle(Model model) {
		logger.debug("User List here!");
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/user/user_list";
	}
	@RequestMapping(value = "/admin/userSearch")
	public String userFindHandle(Model model,@RequestParam(value = "loginName") String loginName) {
		logger.debug("userFindHandle here!");
		User u = new User();
		u.setLogin(loginName);
		List<User> users = userService.findListByCodition(u);
		model.addAttribute("users", users);
		return "admin/user/user_list";
	}
	@RequestMapping(value = "/admin/userDelete")
	public String userDeleteHandle(Model model,@RequestParam(value = "id") int id) {
		logger.debug("userDeleteHandle here!");
		User u = new User();
		u.setUserId(id);
		u  = userService.findById(id);
		userService.remove(u);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/user/user_list";
	}
	
	@RequestMapping(value = "/admin/userEditForm")
	public String userEditFormHandle(Model model,@RequestParam(value = "id") int id) {
		logger.debug("userEditFormHandle here!");
		User u = new User();
		u.setUserId(id);
		u  = userService.findById(id);
		model.addAttribute("user", u);
		model.addAttribute("action","userEdit");
		return "admin/user/user_form";
	}
	
	@RequestMapping(value = "/admin/userEdit")
	public String userEditHandle(Model model,@ModelAttribute( "User" ) @Valid User user) {
		logger.debug("userEditHandle here!");
		User u = new User();
		u.setUserId(user.getUserId());
		u  = userService.findById(u.getUserId());
		u.setLogin(user.getLogin());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setLoginDt(user.getLoginDt());
		userService.merge(u);
		List<User> users = userService.findListByCodition(u);
		model.addAttribute("users", users);
		return "admin/user/user_list";
	}
	
	
	@RequestMapping(value = "/admin/userAddForm")
	public String userAddFormHandle(Model model) {
		logger.debug("userAddFormHandle here!");
		model.addAttribute("action","userAdd");
		return "admin/user/user_form";
	}
	
	@RequestMapping(value = "/admin/userAdd")
	public String userAddHandle(Model model,@ModelAttribute( "User" ) @Valid User user) {
		logger.debug("userEditHandle here!");
		user.setActiveFlg(true);
		userService.persist(user);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/user/user_list";
	}
}
