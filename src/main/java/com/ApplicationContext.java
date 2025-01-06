package com;

import com.repository.TestPostRepository;
import com.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<String, Object> beans;
    private String basePackage;

    public ApplicationContext(String basePackage) {
        this.basePackage = basePackage;
        this.beans = new HashMap<>();
    }

    public void init() {

    }

    public <T> T genBean(String beanName) {
        Object bean = beans.get(beanName);

        if (bean == null) {
            bean =
                    switch (beanName) {
                        case "testPostService" -> new TestPostService(
                                genBean("testPostRepository")
                        );
                        case "testPostRepository" -> new TestPostRepository();
                        default -> null;
                    };

            beans.put(beanName, bean);
        }

        return (T) bean;
    }
}
