package org.example.cifmongo.models;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SecondLevel {
    private String levelName;
    private int levelPrice;
    private ThirdLevel thirdLevel;
}
