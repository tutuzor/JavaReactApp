package com.tutuzor.javareact.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    @Id @GeneratedValue private Long id;
    @NonNull private Long accountId;
    @NonNull private Long amount;
}
