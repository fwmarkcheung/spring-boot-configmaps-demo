package com.redhat.developers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

    private static final Logger LOGGER=LoggerFactory.getLogger(GreeterController.class);

    @Value("${greeter.message}")
    private String greeterMessageFormat;

    @Value("${env}")
    private String env;

    private String version = "v2 - manual trigger";

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETER_PREFIX", "Hi");
        String envProfile = System.getenv().getOrDefault("SRPING_PROFILES_ACTIVE", "default");
        LOGGER.info("Prefix :{} and User:{}", prefix, user);
        LOGGER.info("EnvProfile:{}", envProfile);
        LOGGER.info("env :{}", env);
        LOGGER.info("version :{}", version);
        return String.format(greeterMessageFormat, prefix, user, env, version);
    }
}
