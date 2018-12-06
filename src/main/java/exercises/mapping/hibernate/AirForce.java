package exercises.mapping.hibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AirForce extends Army {

    @Column
    private String jetName;

    @Column
    private int speed;
}
