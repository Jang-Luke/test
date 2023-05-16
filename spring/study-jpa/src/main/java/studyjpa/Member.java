package studyjpa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
public class Member {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private String name;

}
