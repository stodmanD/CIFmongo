package org.example.cifmongo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cifmongo.service.ComponentsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/components")
@RequiredArgsConstructor
public class ComponentsController {

private final ComponentsService componentsService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/createComponents")
    public String createComponents() {

        return componentsService.save();
    }
}
