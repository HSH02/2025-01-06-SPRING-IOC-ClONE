package com.service;

import com.framework.annotations.Service.Service;
import com.repository.TestPostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestFacadePostService {
    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
}