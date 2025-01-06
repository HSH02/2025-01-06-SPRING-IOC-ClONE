package com;

import com.framework.ioc.util.ClsUtil;
import com.repository.TestPostRepository;
import com.service.TestFacadePostService;
import com.service.TestPostService;

import java.util.Arrays;
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
            String clsPath = switch (beanName) {
                case "testPostRepository" -> "com.repository.TestPostRepository";
                case "testFacadePostService" -> "com.service.TestFacadePostService";
                case "testPostService" -> "com.service.TestPostService";
                default -> throw new RuntimeException("Invalid bean name: " + beanName);
            };

            String[] parameterNames = ClsUtil.getParameterNames(clsPath);

            Object[] args = Arrays.stream(parameterNames)
                    .map(this::genBean)
                    .toArray();

            bean = ClsUtil.construct(clsPath, args);

            beans.put(beanName, bean);
        }

        return (T) bean;
    }
}
