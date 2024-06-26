package myworkingproject.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
