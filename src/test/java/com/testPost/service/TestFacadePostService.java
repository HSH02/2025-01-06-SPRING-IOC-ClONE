package com.testPost.service;

import com.framework.annotations.Service;
import com.testPost.repository.TestPostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestFacadePostService {
    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
}