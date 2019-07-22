package com.tutuzor.javareact.models.requests;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountRequest {
    @NonNull private Long custId;
    @NonNull private Long amount;
}
