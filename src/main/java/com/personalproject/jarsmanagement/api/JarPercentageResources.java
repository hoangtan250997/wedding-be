package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.JarPercentageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/income")
public class JarPercentageResources {
    private final JarPercentageService jarPercentageService;

}
