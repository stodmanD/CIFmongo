package org.example.cifmongo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cifmongo.models.*;
import org.example.cifmongo.service.BaseService;
import org.example.cifmongo.service.CreateDateService;
import org.example.cifmongo.service.PostgreBaseService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;
    private final PostgreBaseService postgreBaseService;
    private final CreateDateService createDateService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/createDate")
    public String createDate() {

        return createDateService.save();
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
    @GetMapping(value = "/createChildBase")
    public String createChildBase() {
        var time = System.currentTimeMillis();
        var result = createDateService.saveChild();
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/createSecondChildBase")
    public String createSecondChildBase() {
        var time = System.currentTimeMillis();
        var result = createDateService.saveSecondChild();
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByClassName")
    public List<Base> findByClassName(String className) {
        var time = System.currentTimeMillis();
        var result = baseService.findByClassName(className);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByTitleSecondChild")
    public List<SecondBaseChild> findByTitleSecondChild(String title){
        var time = System.currentTimeMillis();
        var result = baseService.findByTitleSecondChild(title);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByTitle")
    public List<Base> findByTitle(String title) {
        var time = System.currentTimeMillis();
        var result = baseService.findByTitle(title);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByFirstLevelFirstNameAndTitle")
    List<Base> findByFirstLevelFirstNameAndTitle(String firstLevelFirstName, String title) {
        var time = System.currentTimeMillis();
        var result = baseService.findByFirstLevelFirstNameAndTitle(firstLevelFirstName, title);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByChildPrice")
    List<FirstBaseChild> findByChildPrice(int price) {
        var time = System.currentTimeMillis();
        var result = baseService.findByChildPrice(price);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByLevelPrice")
    public List<Base> findByLevelPrice(int levelPrice) {
        var time = System.currentTimeMillis();
        var result = baseService.findByLevelPrice(levelPrice);
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
    public String postgresUpdate(int startIndex, int endIndex) {
        var time = System.currentTimeMillis();
        String result = postgreBaseService.update(startIndex, endIndex);
        var time2 = System.currentTimeMillis();
        log.info("----time is {} ms", time2 - time);
        return result;
    }
}
