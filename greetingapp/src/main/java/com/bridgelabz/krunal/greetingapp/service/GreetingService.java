package com.bridgelabz.krunal.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    /**
     * Purpose : To return message to Controller
     * @return
     */
    public String getMessage(){
        return "Hello World";
    }
}
