package myworkingproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuto;
    private String vinNumber;
    private String brand;
    private String model;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private List<Order> orders;

}
