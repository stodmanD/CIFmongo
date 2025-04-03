package org.example.cifmongo.repository;

import org.example.cifmongo.models.Base;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BaseRepository extends MongoRepository<Base, String> {
    List<Base> findByTitle(String title);

    List<Base> findByFirstLevel_SecondLevel_LevelPrice(int firstLevelSecondLevelLevelPrice);

    List<Base> findByFirstLevel_FirstNameAndTitle(String firstLevelFirstName, String title);

//    {_class:"childRecord",childTitle:"someTitle1"}

    @Query("{ '_class' : ?0 }")
    List<Base> findClass(String className);

}
