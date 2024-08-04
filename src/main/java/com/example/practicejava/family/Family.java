package com.example.practicejava.family;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Family {

    Integer totalNumber;
    String name;
    Boolean money;
    String relation;
    List<Person> person = new ArrayList<Person>();
    public String totalFamily() {
        return person.toString();
    }
}
