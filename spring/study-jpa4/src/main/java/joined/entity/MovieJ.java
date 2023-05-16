package joined.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class MovieJ extends ItemJ {
    private String director;
    private String actor;
}