package com.nobodyiam.spring.cloud.config.demo.client;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by jason on 3/2/16.
 */
@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CloudConfigController) {
            System.out.println("---postProcessBeforeInitialization foo: " + ((CloudConfigController)bean).getFoo());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CloudConfigController) {
            System.out.println("---postProcessAfterInitialization foo: " + ((CloudConfigController)bean).getFoo());
        }
        return bean;
    }
}
