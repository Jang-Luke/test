package entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseAddress extends BaseEntity {
    private String city;
    private String street;
    private String zipcode;
}
