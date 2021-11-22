package com.redhat.developers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreeterController {

    @Value("${greeter.message}")
    private String greeterMessageFormat;

    @Value("${env}")
    private String env;

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETER_PREFIX", "Hi");
        String envProfile = System.getenv().getOrDefault("SRPING_PROFILES_ACTIVE", "default");
        log.info("Prefix :{} and User:{}", prefix, user);
        log.info("EnvProfile:{}", envProfile);
        log.info("env :{}", env);



//        if (prefix == null) {
//            prefix = "Hello!";
//        }

        return String.format(greeterMessageFormat, prefix, user, env);
    }
}
