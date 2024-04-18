package myworkingproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

import static myworkingproject.entity.OrderStatus.*;

@Entity
@Getter
@Setter

//@ToString
//@EqualsAndHashCode

@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @JsonIgnore
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
    private OrderStatus status = CREATED;
    private String description;

}
