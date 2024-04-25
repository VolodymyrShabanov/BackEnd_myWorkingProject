package myworkingproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderItem;
    private Integer quantity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private SparePart sparePart;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my")
    private MyOrder myOrder;

}
