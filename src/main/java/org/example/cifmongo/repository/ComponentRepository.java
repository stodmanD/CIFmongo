package org.example.cifmongo.repository;

import org.example.cifmongo.models.ComponentDate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComponentRepository extends MongoRepository<ComponentDate, String> {
}
