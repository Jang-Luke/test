package joined.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class BookJ extends ItemJ {
    private String author;
    private String isbn;
}