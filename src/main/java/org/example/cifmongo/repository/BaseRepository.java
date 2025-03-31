package org.example.cifmongo.repository;

import org.example.cifmongo.models.Base;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BaseRepository extends MongoRepository<Base, String> {
    List<Base> findByTitle(String title);
}
