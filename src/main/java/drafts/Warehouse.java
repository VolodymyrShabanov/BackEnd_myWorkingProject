//package drafts;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Warehouse {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idWarehouse;
//    private String name;
//
////    @ElementCollection
////    @CollectionTable(
////            name = "warehouse_spare_parts",
////            joinColumns = @JoinColumn(name = "warehouse_id"))
////    @MapKeyJoinColumn(name = "spare_part_id")
////    @Column(name = "quantity")
////    private Map<SparePart, Integer> spareParts;
//
////    @JsonIgnore
////    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
////    private List<SparePartQuantity> sparePartQuantityList;
//
//
//}
