package com.codedifferently.watertrackerapi.domain.person.models;

import com.codedifferently.watertrackerapi.domain.log.models.Log;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String userName;

    @NonNull
    private Integer age;

    @NonNull
    private Double weight;

}
