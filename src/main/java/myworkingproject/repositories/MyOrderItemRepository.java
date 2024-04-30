package myworkingproject.repositories;


import myworkingproject.entitys.MyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyOrderItemRepository extends JpaRepository<MyOrderItem, Integer> {

    Optional<MyOrderItem> findByIdMyOrderItem(Integer idMyOrderItem);

    List<MyOrderItem> findBySparePartIdSparePart(Integer idSparePart);

    List<MyOrderItem> findByMyOrder_IdMyOrder(Integer idMyOrder);

}
