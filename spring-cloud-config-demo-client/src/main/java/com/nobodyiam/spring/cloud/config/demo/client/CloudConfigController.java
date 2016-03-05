package com.nobodyiam.spring.cloud.config.demo.client;

import com.nobodyiam.spring.cloud.config.demo.model.Config;
import com.nobodyiam.spring.cloud.config.demo.model.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jason on 2/24/16.
 */
@RestController
@RefreshScope
@RequestMapping("/demo")
public class CloudConfigController {
    private static final String APPLICATION_NAME_CONFIG = "spring.application.name";
    private static final String ACTIVE_PROFILE_CONFIG = "spring.profiles.active";
    private static final String LABEL_CONFIG = "spring.cloud.config.label";
    private static final String CONFIG_SERVER_CONFIG = "spring.cloud.config.uri";

    @Autowired
    private Environment env;

    @Value("${spring.profiles.active}")
    private String currentActiveProfiles;

    private String foo;

    @RequestMapping(value = "/config/{configName:.*}", method = RequestMethod.GET)
    public Config queryConfig(@PathVariable String configName) {
        return new Config(configName, env.getProperty(configName, "undefined"));
    }

    @RequestMapping(value = "/env", method = RequestMethod.GET)
    public EnvironmentConfig queryEnv() {
        return EnvironmentConfig.builder()
                .application(env.getProperty(APPLICATION_NAME_CONFIG))
                .profiles(env.getProperty(ACTIVE_PROFILE_CONFIG))
                .label(env.getProperty(LABEL_CONFIG))
                .serverUri(env.getProperty(CONFIG_SERVER_CONFIG))
                .build();
    }

    public String getCurrentActiveProfiles() {
        return currentActiveProfiles;
    }

    public String getFoo() {
        return foo;
    }

    @Value("${foo}")
    public void setFoo(String foo) {
        this.foo = foo;
    }
}
