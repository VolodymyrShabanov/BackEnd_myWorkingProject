package myworkingproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuto;
    private String vinNumber;
    private String brand;
    private String model;

    @JsonIgnore
    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private List<MyOrder> myOrders;

}
