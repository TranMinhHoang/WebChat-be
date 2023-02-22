package com.web.webchat.controllers;

import com.web.webchat.models.User;
import com.web.webchat.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
//@RequestMapping("/api/test")
@RequestMapping("/api")
public class UserController {

//	@GetMapping("/all")
//	public MessageResponse allAccess() {
//		return new MessageResponse("Server is up.....");
//	}
//
//	@GetMapping("/greeting")
//	@PreAuthorize("isAuthenticated()")
//	public MessageResponse userAccess() {
//
//		return new MessageResponse("Congratulations! You are an authenticated user.");
//	}
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> listUser = userRepository.findAll();
        if (listUser.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }
    
    
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public User findUser(@PathVariable("id") long id) {
//        User user = userRepository.getOne(id);
//        if (user == null) {
//            ResponseEntity.notFound().build();
//        }
//        return user;
//    }

}
