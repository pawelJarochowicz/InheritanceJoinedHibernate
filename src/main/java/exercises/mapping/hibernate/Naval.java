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
public class Naval extends Army{

    @Column
    private String shipNames;

    @Column
    private int displacement;
}
