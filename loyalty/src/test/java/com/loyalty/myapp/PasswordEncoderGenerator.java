package com.loyalty.myapp;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordEncoderGenerator {

	 public static void main(String[] args) {  
		 //a37cc5cf4d05229fcd82fc7256d719ee
		 Md5PasswordEncoder md5 = new Md5PasswordEncoder();  
		 String strEncodedPassword = md5.encodePassword("offdong",null);  
		 System.out.println(strEncodedPassword);  
	 }  
}