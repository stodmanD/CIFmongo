package org.example.cifmongo.models;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
@TypeAlias("childRecord")
@Document(collection = "testRecord")
public class FirstBaseChild extends Base {

    private String childTitle;

    private String name;

    public String getChildTitle() {
        return childTitle;
    }

    public void setChildTitle(String childTitle) {
        this.childTitle = childTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FirstBaseChild(String title, FirstLevel firstLevel, String childTitle, String name) {
        super(title, firstLevel);
        this.childTitle = childTitle;
        this.name = name;
    }

}
