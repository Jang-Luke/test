package dto;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDTO {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String contact;
}
