package org.example.cifmongo.repository;

import org.example.cifmongo.models.FirstBaseChild;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChildBaseRepository extends MongoRepository<FirstBaseChild, String> {
    List<FirstBaseChild> findByFirstLevel_SecondLevel_LevelPrice(int firstLevelSecondLevelLevelPrice);
}
