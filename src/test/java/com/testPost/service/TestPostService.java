package com.testPost.service;

import com.framework.annotations.Service;
import com.testPost.repository.TestPostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestPostService {
    private final TestPostRepository testPostRepository;
}
