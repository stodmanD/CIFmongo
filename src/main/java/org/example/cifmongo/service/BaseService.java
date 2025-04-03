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
@RequiredArgsConstructor
@Slf4j
public class BaseService {

    private final BaseRepository repository;
    private final ChildBaseRepository childBaseRepository;
    private final SecondChildBaseRepository secondChildBaseRepository;

    private final int repeatable = 50;
    private final String name = "firstTest";
    private final String anything = "firstAnythingTest";

    private final String nameTest = "test";
    private final String anythingTest = "anythingTest";


   public List<Base> findByFirstLevelFirstNameAndTitle(String firstLevelFirstName, String title){
        return repository.findByFirstLevel_FirstNameAndTitle(firstLevelFirstName, title);
    }

    public List<Base> findByClassName(String className){
        return repository.findClass(className);
    }

    public List<FirstBaseChild> findByChildPrice(int price){
        return childBaseRepository.findByFirstLevel_SecondLevel_LevelPrice(price);
    }

    public Base getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Base updateById(Base base) {
        return repository.save(base);
    }

    public String updateAllByThirdLevel(ThirdLevel thirdLevel) {
        List<Base> list = repository.findAll();
        for (Base obj : list) {
            FirstLevel firstLevel = obj.getFirstLevel();
            SecondLevel secondLevel = firstLevel.getSecondLevel();
            secondLevel.setThirdLevel(thirdLevel);
            firstLevel.setSecondLevel(secondLevel);
            obj.setFirstLevel(firstLevel);
            repository.save(obj);
        }
        return "Update successful";
    }

    public String updateAllBySecondLevel(SecondLevel secondLevel) {
        var time = System.currentTimeMillis();
        List<Base> list = repository.findAll();
        var time2 = System.currentTimeMillis();
        for (Base obj : list) {
            FirstLevel firstLevel = obj.getFirstLevel();
            firstLevel.setSecondLevel(secondLevel);
            obj.setFirstLevel(firstLevel);
            repository.save(obj);
        }
        return "Update successful";
    }
public List<Base> findByTitle(String title) {
        return repository.findByTitle(title);
}

    public List<SecondBaseChild> findByTitleSecondChild(String title) {
        return secondChildBaseRepository.findByTitle(title);
    }

    public List<Base> findByLevelPrice(int levelPrice) {
        return repository.findByFirstLevel_SecondLevel_LevelPrice(levelPrice);
    }

}
