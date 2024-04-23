//package drafts;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import lombok.AllArgsConstructor;
//import myworkingproject.entity.SparePart;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@Service
//@AllArgsConstructor
//public class SparePartFromWarehouse {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public Map<SparePart, Integer> findByIdSparePart(Integer sparePartId) {
//
//        List<Object[]> results = entityManager.createQuery(
//                        "SELECT wsp, SIZE(wsp) " +
//                                "FROM Warehouse w JOIN w.spareParts wsp " +
//                                "WHERE KEY(wsp) = :sparePartId", Object[].class)
//                .setParameter("sparePartId", sparePartId)
//                .getResultList();
//
//        Map<SparePart, Integer> sparePartsQuantities = new HashMap<>();
//        for (Object[] result : results) {
//            SparePart sparePart = (SparePart) result[0];
//            Long quantity = (Long) result[1]; // Используем Long, так как SIZE() возвращает Long
//            sparePartsQuantities.put(sparePart, quantity.intValue());
//        }
//        return sparePartsQuantities;
//    }
//
//
//}
