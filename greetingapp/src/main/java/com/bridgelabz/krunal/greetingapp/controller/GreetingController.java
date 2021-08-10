/************************************************************************************************
 *
 * Purpose : Using GreetingController return JSON for different HTTP Methods. Test using curl
 *
 * @author Krunal Lad
 * @since 10-08-2021
 *
 ************************************************************************************************/
package com.bridgelabz.krunal.greetingapp.controller;

import com.bridgelabz.krunal.greetingapp.dto.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s Welcome to Bridgelabz";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Purpose : Ability to return JSON data using GET method
     *
     * @param name
     * @return
     */
    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    /**
     * Execution URL :
     * 1. curl localhost:8080/getGreeting -w "\n"
     * 2. curl localhost:8080/getGreeting?name=Krunal -w "\n"
     */

    /**
     * Purpose : Ability to return JSON data using POST method
     *
     * @param greeting
     * @return
     */
    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(),String.format(template,greeting.getContent()));
    }

    /**
     * Execution URL : curl -X POST -H "Content-Type: application/json" -d '{"content":"Krunal"}'
     *                 "http://localhost:8080/postGreeting" -w "\n"
     */

    /**
     * Purpose : Ability to return JSON data using PUT method
     *
     * @param counter
     * @param contentName
     * @return
     */
    @PutMapping("/putGreeting/{counter}")
    public Greeting sayHello(@PathVariable int counter,@RequestParam(value = "content")String contentName){
        return new Greeting(counter,String.format(template,contentName));
    }

    /**
     * Execution URL : curl -X PUT localhost:8080/putGreeting/1/?content=Krunal -w "\n"
     */
}
