package org.example.cifmongo.models;

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ThirdLevel {

    private String name;
    private int price;
    private String anything;
}
