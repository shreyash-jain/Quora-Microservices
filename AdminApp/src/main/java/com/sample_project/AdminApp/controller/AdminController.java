package com.sample_project.AdminApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample_project.AdminApp.dto.GloQuoraPostDto;
import com.sample_project.AdminApp.dto.UserDetailsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Quora")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	ObjectMapper objectMapper = new ObjectMapper();

//	@Autowired
//	AdminService adminService;

	@GetMapping(value = "/getPostByUserId/{id}")
	public String getUserPostById(@PathVariable("id") String userId) {
		logger.info("Inside getUserPostById of AdminController");
		try {
            String result =  new RestTemplate().getForObject("http://localhost:9002/userspost/getPost/" + userId, String.class);
            if(result.equals("")) return "No such user present";
        	return result;
		}
        catch(Exception e){
			System.out.println(e.getMessage());
		}
	return "";
	}

	@GetMapping(value = "/getAllUserPost")
	public Map<UserDetailsDto,List<GloQuoraPostDto>> getAllUsersPost() {
//		logger.info("Inside getAllUsersPost of AdminController");
//		return new ResponseEntity<Object>(adminService.getAllUserPost(), HttpStatus.OK);

		Map<UserDetailsDto,List<GloQuoraPostDto>> result = new HashMap<UserDetailsDto,List<GloQuoraPostDto>>();

		List users = new RestTemplate().getForObject("http://localhost:9001/User/getAll", List.class);
		for(Object o: users){
			UserDetailsDto user = objectMapper.convertValue(o,UserDetailsDto.class);
			List posts = new RestTemplate().getForObject("http://localhost:9002/userspost/getPost/"+user.getId(), List.class);
			result.put(user,posts);
		}
		return result;
	}



	
//	@GetMapping(value = "/getUserPostGReaterThanANumber")
//	public List<UserDetailsDto> getUserPostByCount(@RequestParam Long postCount) {
//		logger.info("Inside getUserPostGReaterThanANumber of AdminController");
//		return new ResponseEntity<Object>(adminService.getUserPostByNumber(postCount), HttpStatus.OK);
//	}
//
	@GetMapping(value = "/getCompanyName")
	public List<String > getCompanyNames() {
		logger.info("Inside getCompanyNames of AdminController");
		List users = new RestTemplate().getForObject("http://localhost:9001/User/getAll", List.class);
		List<String> companyNames = new ArrayList<String>();
		for(Object o:users){
			companyNames.add(objectMapper.convertValue(o,UserDetailsDto.class).getCompany().getName());
		}
		return companyNames;
	}
}
