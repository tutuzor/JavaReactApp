package com.tutuzor.javareact.models.requests;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountRequest {
    @NonNull private Long custId;
    @NonNull private Double amount;
}
