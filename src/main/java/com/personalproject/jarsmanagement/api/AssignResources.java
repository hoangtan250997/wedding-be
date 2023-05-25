package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.AssignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assign")
public class AssignResources {
    private final AssignService assignService;

}
