package com.service;

import com.framework.annotations.Service.Service;
import com.repository.TestPostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestPostService {
    private final TestPostRepository testPostRepository;
}
