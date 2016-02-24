package com.nobodyiam.spring.cloud.config.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2/24/16.
 */
@RestController
@RefreshScope
@RequestMapping("/demo")
public class SomeClientController {
    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.GET)
    public String foo() {
        return env.getProperty("foo", "undefined");
    }
}
