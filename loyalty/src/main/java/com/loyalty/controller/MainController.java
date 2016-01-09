package com.loyalty.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loyalty.exception.CustomGenericException;
import com.sun.jmx.snmp.Timestamp;


@Controller
public class MainController {
		
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
//	@Autowired
//	private UserService userService;
		
	
	
	@RequestMapping(value = "/example/{path}", method = RequestMethod.GET)
	public ModelAndView exampleHandler(@PathVariable("path") String path, HttpServletRequest request){
		logger.debug("example bootstap page here! ");
		logger.debug("@PathVariable! =  "+ path+"  >>>>> "+"/example/"+path+"/index.jsp");
		return new ModelAndView("example/"+path+"/index");
	}
	
	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public ModelAndView exampleIndexHandler( HttpServletRequest request){
		logger.debug("example index page here! ");
		return new ModelAndView("example/example");
	}
	
	
	// for test service 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexHandler(){
		logger.debug("index page here ! ");

		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeHandler(){
		logger.debug("index page here ! ");

		return new ModelAndView("home");
	}
	
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView errorHandler(HttpServletRequest req){
		
		CustomGenericException custEx = (CustomGenericException)req.getAttribute("customGenericException");
		logger.debug("Error Page! "+custEx.getErrCode()+" Msg: "+ custEx.getErrMsg());
		return new ModelAndView("error","customGenericException",custEx);
	}
	
	
	@InitBinder
	public void binder(WebDataBinder binder) {binder.registerCustomEditor(Date.class,
	    new PropertyEditorSupport() {
	        public void setAsText(String value) {
	                Date parsedDate;
					try {
						parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
				
						setValue(new Timestamp(parsedDate.getTime()));
					} catch (ParseException e) {
						 setValue(null);
					}
	        }
	    });
	}
	
	
		@RequestMapping(value = "/contactus", method = RequestMethod.GET)
		public ModelAndView contactusHandler(){
			logger.debug("contactusHandler page here ! ");
		
			return new ModelAndView("contactus");
		}
		@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
		public ModelAndView aboutusHandler(){
			logger.debug("aboutusHandler page here ! ");
		
			return new ModelAndView("aboutus");
		}
	
}
