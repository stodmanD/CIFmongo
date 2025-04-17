package org.example.cifmongo.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OptionDate {

    private String name;
    private String title;
    private String description;
    private boolean type;
    List<Object> elementType;
    private boolean isRequired;
    private boolean isLocked;
    private boolean isVisible;
    private boolean canBindVariable;
    private boolean isResult;
    private String defaultValue;
    private boolean defaultIsVisible;
    private boolean defaultIsReadonly;
    private boolean defaultIsLocked;
    private List<OptionDate> options;

}
