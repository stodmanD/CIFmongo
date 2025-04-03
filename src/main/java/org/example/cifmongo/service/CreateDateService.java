package org.example.cifmongo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cifmongo.models.*;
import org.example.cifmongo.repository.BaseRepository;
import org.example.cifmongo.repository.ChildBaseRepository;
import org.example.cifmongo.repository.SecondChildBaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateDateService {

    private final BaseRepository repository;
    private final ChildBaseRepository childBaseRepository;
    private final SecondChildBaseRepository secondChildBaseRepository;

    private final int repeatable = 50;
    private final String name = "firstTest";
    private final String anything = "firstAnythingTest";

    private final String nameTest = "test";
    private final String anythingTest = "anythingTest";

    private final String organisation = "organisation";
    private final String department = "department";


    public String saveChild() {
        List<FirstBaseChild> list = prepareChildDate();
        List<FirstBaseChild> listTest = prepareTestChildDate();
        list.addAll(listTest);
        for (var obj : list) {
            childBaseRepository.save(obj);
        }
        return "Saved successful";
    }

    public String save() {
        List<Base> list = prepareDate();
        List<Base> listTest = prepareTestDate();
        list.addAll(listTest);
        for (var obj : list) {
            repository.save(obj);
        }
        return "Saved successful";
    }

    public String saveSecondChild() {
        List<SecondBaseChild> list = prepareSecondChildDate();
        List<SecondBaseChild> listTest = prepareTestSecondChildDate();
        list.addAll(listTest);
        for (var obj : list) {
            secondChildBaseRepository.save(obj);
        }
        return "Saved successful";
    }

    private List<Base> prepareDate() {
        List<Base> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(name + i)
                    .price(10 + i)
                    .anything(anything + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anything + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + name + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new Base(anything + i, firstLevel));
        }
        return result;
    }

    private List<SecondBaseChild> prepareSecondChildDate() {
        List<SecondBaseChild> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(name + i)
                    .price(10 + i)
                    .anything(anything + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anything + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + name + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new SecondBaseChild(anything + i, firstLevel, organisation, department));
        }
        return result;
    }

    private List<SecondBaseChild> prepareTestSecondChildDate() {
        List<SecondBaseChild> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(nameTest + i)
                    .price(10 + i)
                    .anything(anythingTest + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anythingTest + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + nameTest + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new SecondBaseChild(anythingTest + i, firstLevel, organisation, department));
        }
        return result;
    }

    private List<FirstBaseChild> prepareChildDate() {
        List<FirstBaseChild> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(name + i)
                    .price(10 + i)
                    .anything(anything + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anything + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + name + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new FirstBaseChild(anything + i, firstLevel, "someTitle", "someName"));
        }
        return result;
    }

    private List<FirstBaseChild> prepareTestChildDate() {
        List<FirstBaseChild> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(nameTest + i)
                    .price(10 + i)
                    .anything(anythingTest + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anythingTest + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + nameTest + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new FirstBaseChild(anythingTest + i, firstLevel, "someTitle", "someName"));
        }
        return result;
    }

    private List<Base> prepareTestDate() {
        List<Base> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            ThirdLevel thirdLevel = ThirdLevel.builder()
                    .name(nameTest + i)
                    .price(10 + i)
                    .anything(anythingTest + i)
                    .build();
            SecondLevel secondLevel = SecondLevel.builder()
                    .thirdLevel(thirdLevel)
                    .levelName(anythingTest + i)
                    .levelPrice(15 + i)
                    .build();
            FirstLevel firstLevel = FirstLevel.builder()
                    .firstName("first" + nameTest + i)
                    .secondLevel(secondLevel)
                    .build();
            result.add(new Base(anythingTest + i, firstLevel));
        }
        return result;
    }
}
