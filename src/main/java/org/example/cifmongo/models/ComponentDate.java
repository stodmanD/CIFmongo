package org.example.cifmongo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "component")
public class ComponentDate {

    private String name;
    private int versionMajor;
    private int versionMinor;
    private int versionPatch;
    private String codeName;
    private String title;
    private String description;
    private List<OptionDate> options;

    public ComponentDate(String name, int versionMajor, int versionMinor, int versionPatch, String codeName, String title, String description, List<OptionDate> options) {
        this.name = name;
        this.versionMajor = versionMajor;
        this.versionMinor = versionMinor;
        this.versionPatch = versionPatch;
        this.codeName = codeName;
        this.title = title;
        this.description = description;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersionMajor() {
        return versionMajor;
    }

    public void setVersionMajor(int versionMajor) {
        this.versionMajor = versionMajor;
    }

    public int getVersionMinor() {
        return versionMinor;
    }

    public void setVersionMinor(int versionMinor) {
        this.versionMinor = versionMinor;
    }

    public int getVersionPatch() {
        return versionPatch;
    }

    public void setVersionPatch(int versionPatch) {
        this.versionPatch = versionPatch;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OptionDate> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDate> options) {
        this.options = options;
    }
}
