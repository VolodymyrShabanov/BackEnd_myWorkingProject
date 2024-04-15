package myworkingproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    private Auto auto;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_spare_parts",
            joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyJoinColumn(name = "spare_part_id")
    @Column(name = "quantity")
    private Map<SparePart, Integer> spareParts;

    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;
    private String description;

}
