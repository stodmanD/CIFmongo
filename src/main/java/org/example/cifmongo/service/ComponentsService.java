package org.example.cifmongo.service;

import lombok.RequiredArgsConstructor;
import org.example.cifmongo.models.*;
import org.example.cifmongo.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComponentsService {

    private final ComponentRepository componentRepository;

    private final int repeatable = 50;
    private final String name = "firstTest";
    private final String anything = "firstAnythingTest";

    private final String nameTest = "test";
    private final String anythingTest = "anythingTest";

    private final String organisation = "organisation";
    private final String department = "department";


    public String save() {
        List<ComponentDate> list = prepareChildDate();

        for (ComponentDate componentDate : list) {
            componentRepository.save(componentDate);
        }
        return "Saved";
    }

    private List<ComponentDate> prepareChildDate() {
        List<ComponentDate> result = new ArrayList<>();
        for (int i = 0; i <= repeatable; i++) {
            OptionDate firstOption = OptionDate.builder()
                    .name(name + i)
                    .title(name + i)
                    .description(anything + i)
                    .type(true)
                    .elementType(new ArrayList<>())
                    .isRequired(true)
                    .isLocked(true)
                    .isVisible(true)
                    .canBindVariable(true)
                    .isResult(true)
                    .defaultValue(anything + i)
                    .defaultIsVisible(true)
                    .defaultIsReadonly(true)
                    .defaultIsLocked(true)
                    .build();
            List <OptionDate> sdf = new ArrayList<>();
            sdf.add(firstOption);
            sdf.add(firstOption);
            OptionDate secondOption = OptionDate.builder()
                    .name(name + i)
                    .title(name + i)
                    .description(anything + i)
                    .type(true)
                    .elementType(new ArrayList<>())
                    .isRequired(true)
                    .isLocked(true)
                    .isVisible(true)
                    .canBindVariable(true)
                    .isResult(true)
                    .defaultValue(anything + i)
                    .defaultIsVisible(true)
                    .defaultIsReadonly(true)
                    .defaultIsLocked(true)
                    .options(sdf)
                    .build();

            List <OptionDate> oppp = new ArrayList<>();
            oppp.add(secondOption);
            oppp.add(secondOption);
            result.add(new ComponentDate(anything + i, 1,1,1, organisation, department,name, oppp));

        }
        return result;
    }
}
