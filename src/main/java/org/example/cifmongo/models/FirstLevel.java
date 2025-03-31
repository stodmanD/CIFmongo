package org.example.cifmongo.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FirstLevel {
    private String firstName;
    private SecondLevel secondLevel;
}
