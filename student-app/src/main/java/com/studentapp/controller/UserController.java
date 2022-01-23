package com.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.dto.AddUserRequestDto;
import com.studentapp.dto.Status;
import com.studentapp.response.BaseResponse;
import com.studentapp.service.impl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User Controller Provider")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@CrossOrigin("*")
	@ApiOperation(value = "It is to add new user")
	@PostMapping("/addUser")
	public ResponseEntity<BaseResponse<String, Long>> addUser(AddUserRequestDto dto) {
		BaseResponse<String, Long> response = new BaseResponse<>();
		userService.addUser(dto);
		response.setMessage("User added successfully.");
		response.setStatus(Status.SUCCESS);
		return ResponseEntity.ok(response);
	}
}
