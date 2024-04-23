//package drafts;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import myworkingproject.entity.Auto;
//import myworkingproject.entity.OrderStatus;
//import myworkingproject.entity.MyOrderItem;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static myworkingproject.entity.OrderStatus.CREATED;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class MyOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idOrder;
//
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Auto auto;
//
////    @ElementCollection(fetch = FetchType.EAGER)
////    @CollectionTable(name = "order_spare_parts",
////            joinColumns = @JoinColumn(name = "order_id"))
////    @MapKeyJoinColumn(name = "spare_part_id")
////    @Column(name = "quantity")
////    private Map<SparePart, Integer> spareParts;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL)
//    private List<MyOrderItem> sparePartQuantitieList;
//
//    private LocalDateTime createDate;
//    private LocalDateTime lastUpdate;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status = CREATED;
//    private String description;
//
//}
