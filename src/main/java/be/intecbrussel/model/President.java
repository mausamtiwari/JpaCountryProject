package be.intecbrussel.model;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor


@Entity
@Table(name = "president")
public class President {
    @Id
    private String name;

    private int age;

}
