package myworkingproject.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static myworkingproject.entitys.OrderStatus.CREATED;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMyOrder;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Auto auto;

    @JsonIgnore
    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyOrderItem> myOrderItemsList;

    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = CREATED;
    private String description;

}
