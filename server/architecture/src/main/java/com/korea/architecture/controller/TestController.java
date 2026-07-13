package com.korea.architecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//웹페이지가 아닌 데이터를 반환하는 컨트롤러로 사용된다.
//HTML같은 페이지를 반환하는 대신 JSON이나 XML형식의 데이터를 반환
//@Controller + @ResponseBody의 결합
//@RequestMapping("test")//리소스
public class TestController {
	
	@GetMapping("/testGetMapping")
	//스프링 프레임워크에서 HTTP GET 요청을 처리하기위한 어노테이션
	//특정 경로로 들어오는 GET 요청을 처리하고, 그 요청에 대한
	//응답을 반환하는데 사용한다.
	//하나의 컨트롤러에서 여러개의 GetMapping이 사용될 수 있기
	//때문에 식별자를 사용한다.
	public String testController() {
		return "Hello World testGetMapping";
	}
	
	@GetMapping("testGetMapping2")
	public String testController2() {
		return "Nice too meet you";
	}
	
	//@PathVariable
	//URL 경로의 일부분을 변수로 받아올 수 있다.
	@GetMapping("/users/{id}")
	public String getUserById(@PathVariable("id")Long userId) {
		return "User ID : " + userId;
	}
	
	@GetMapping({
		"/users/{id}/orders",
		"/users/{id}/orders/{orderId}"})
	public String order(
			@PathVariable("id")Long userId,
			//required =true : 경로 변수 값이 반드시 있어야 한다.
			//매개변수이름과 경로 변수 이름이 같으면 생략할 수 있다.
			@PathVariable(required=false)Long orderId) {
		return "UserID : " + userId + ",Order ID : " + orderId;
	}
	
	@GetMapping("/users")
	public String getUser(@RequestParam(value="id", defaultValue="999") Long userId) {
		return "UserID : " + userId;
	}
	
	@GetMapping("/search")
	public String search(
			@RequestParam("query")String query,
			@RequestParam("page") int page) {
		return "Search query : " + query + ", Page : " + page;
	}
	

}






