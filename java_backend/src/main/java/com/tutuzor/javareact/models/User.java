package com.tutuzor.javareact.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue private Long id;
    @NonNull private String name;
}
