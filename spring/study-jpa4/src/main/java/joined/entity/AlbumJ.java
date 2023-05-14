package joined.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class AlbumJ extends ItemJ {
    private String artist;
}