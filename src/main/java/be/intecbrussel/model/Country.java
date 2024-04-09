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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_name")
    private String name;

    @Column(name = "country_population")
    private int population;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private President president;

}
