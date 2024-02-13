package com.masteroflie.Spring.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import com.masteroflie.Spring.Project.models.user;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}
	
@RestController 
public class DefaultController {
    @GetMapping("/")
    public String defaultRoute() {
		user n = new user(1L,"Matheus","dev@dev","dev");
        return n.getUsername() + " " + n.getEmail() + " " + n.getPassword();
    }
}

}
