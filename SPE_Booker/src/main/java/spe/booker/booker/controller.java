package spe.booker.booker;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    public static void main(String[] args) {
    }

}