package org.example.cifmongo.repository;

import org.example.cifmongo.models.Base;
import org.example.cifmongo.models.SecondBaseChild;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SecondChildBaseRepository extends MongoRepository<SecondBaseChild, String> {
    List<SecondBaseChild> findByTitle(String title);
}
