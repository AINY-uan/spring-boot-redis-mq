package org.ainy.controller;

import lombok.extern.slf4j.Slf4j;
import org.ainy.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 阿拉丁省油的灯
 * @Date 2020-01-06 21:25
 * @Description 测试
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final PublisherService publisherService;

    @Autowired
    public TestController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String send(String name) {

        publisherService.sendMessage(name);

        return "success";
    }
}
