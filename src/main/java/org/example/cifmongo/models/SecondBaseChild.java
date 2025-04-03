package org.example.cifmongo.models;


import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias("secondChildRecord")
@Document(collection = "testRecord")
public class SecondBaseChild extends Base {

    private String organisation;

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


    public SecondBaseChild(String title, FirstLevel firstLevel, String organisation, String department) {
        super(title, firstLevel);
        this.organisation = organisation;
        this.department = department;
    }
}
