package org.example.cifmongo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cifmongo.models.Base;
import org.example.cifmongo.models.SecondLevel;
import org.example.cifmongo.models.ThirdLevel;
import org.example.cifmongo.service.BaseService;
import org.example.cifmongo.service.PostgreBaseService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;
    private final PostgreBaseService postgreBaseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/createDate")
    public String createDate() {

        return baseService.save();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/postgreCreateDate")
    public String postgreCreateDate() {

        return postgreBaseService.save();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getById")
    public Base getById(String id) {
        var time = System.currentTimeMillis();
        Base result = baseService.getById(id);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);

        return result;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getByIdThirdLevel")
    public ThirdLevel getByIdThirdLevel(String id) {
        var time = System.currentTimeMillis();
        var result = baseService.getById(id).getFirstLevel().getSecondLevel().getThirdLevel();
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/updateById")
    public Base updateById(@RequestBody Base base) {
        var time = System.currentTimeMillis();
        Base result = baseService.updateById(base);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/updateAllByThirdLevel")
    public String updateAllByThirdLevel(@RequestBody ThirdLevel thirdLevel) {
        var time = System.currentTimeMillis();
        String result = baseService.updateAllByThirdLevel(thirdLevel);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/updateAllBySecondLevel")
    public String updateAllBySecondLevel(@RequestBody SecondLevel secondLevel) {
        var time = System.currentTimeMillis();
        String result = baseService.updateAllBySecondLevel(secondLevel);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/postgresById")
    public String postgresById(int id) {
        var time = System.currentTimeMillis();
        String result = postgreBaseService.getById(id);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/postgresUpdate")
    public String postgresUpdate(int startIndex,int endIndex) {
        var time = System.currentTimeMillis();
        String result = postgreBaseService.update(startIndex, endIndex);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }
}
