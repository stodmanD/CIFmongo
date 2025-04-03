package org.example.cifmongo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testRecord")
public class Base {
    @Id
    private String id;
    private String title;
    private FirstLevel firstLevel;
//    private String _class;

    public Base(String title, FirstLevel firstLevel) {
        this.title = title;
        this.firstLevel = firstLevel;
    }

    public Base() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FirstLevel getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(FirstLevel firstLevel) {
        this.firstLevel = firstLevel;
    }
}
