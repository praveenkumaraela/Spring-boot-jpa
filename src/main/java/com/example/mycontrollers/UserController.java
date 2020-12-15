package com.example.mycontrollers;

import com.example.demo.basicconfiguration.BasicConfiguration;
import com.example.demo.model.ErrorDetails;
import com.example.demo.model.UserRecord;
import com.example.demo.service.UserService;
import customexceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasicConfiguration basicConfig;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/MyConfiguredProperty")
	public Map<String, Object> getBasicConfiguredProp() {
		Map<String,Object> props = new HashMap<String,Object>();
		
		props.put("value", basicConfig.isValue());
		props.put("message", basicConfig.getMessage());
		props.put("number", basicConfig.getNumber());
		return props;
	}

	//@RequestMapping(value="/users",method=RequestMethod.GET)
	@GetMapping("/users")
	public List<UserRecord> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public UserRecord  getUser(@PathVariable String id) {
		
		if(id.equalsIgnoreCase("5")) {
			throw new RuntimeException();
		}
		
		if(id.equalsIgnoreCase("6")) {
			throw new UserNotFoundException("User 6 is not ther, go stupid");
		}
		
		return userService.getUser(id);

	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public void addUser(@Valid @RequestBody UserRecord record){
		userService.addUser(record);
	}
	
	@PostMapping("/addanyuser")
	public ResponseEntity<Void> addAnyUser(@Valid @RequestBody UserRecord record){
		userService.addUser(record);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/added").buildAndExpand(record.getFirstname()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
		
		 
			 ErrorDetails errorDetails = new ErrorDetails(new Date(), "Hey Request Validation Failed",
					 exception.getBindingResult().toString());
			 return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
