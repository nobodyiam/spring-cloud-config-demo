package com.nobodyiam.spring.cloud.config.demo.client;

import com.nobodyiam.spring.cloud.config.demo.model.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2/24/16.
 */
@RestController
@RefreshScope
@RequestMapping("/demo")
public class CloudConfigController {
    @Autowired
    private Environment env;

    @RequestMapping(value = "/config/{configName}", method = RequestMethod.GET)
    public String queryConfig(@PathVariable String configName) {
        return env.getProperty(configName, "undefined");
    }

    @RequestMapping(value = "/env", method = RequestMethod.GET)
    public EnvironmentConfig queryEnv() {
        return new EnvironmentConfig();
    }

}
