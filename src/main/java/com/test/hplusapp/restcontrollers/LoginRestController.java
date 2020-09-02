package com.test.hplusapp.restcontrollers;

import com.test.hplusapp.Login;
import com.test.hplusapp.beans.User;
import com.test.hplusapp.exceptions.LoginFailException;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailException {
        System.out.println(login.getUsername()+" "+login.getPassword());
        User user = userRepository.searchByName(login.getUsername());

        if(user==null){
//            return  ResponseEntity.status(404).build();
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }

        if(user.getUsername().equals(login.getUsername())&&
        user.getPassword().equals(login.getPassword())){
            return new ResponseEntity<>("Welcome,"+user.getUsername(),HttpStatus.OK);
        }
        else {
            //throw exception
            throw new LoginFailException("Invalid username or password");
        }
    }
}
