package myworkingproject.repository;


import myworkingproject.entity.MyOrder;
import myworkingproject.entity.SparePart;
import myworkingproject.entity.MyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyOrderItemRepository extends JpaRepository<MyOrderItem, Integer> {

    Optional<MyOrderItem> findByIdOrderItem(Integer idOrderItem);

    List<MyOrderItem> findBySparePart(SparePart sparePart);

    List<MyOrderItem> findBySparePartIdSparePart(Integer idSparePart);

    List<MyOrderItem> findByMyOrder(MyOrder myOrder);

    List<MyOrderItem> findByMyOrder_IdOrder(Integer idOrder);

    Optional<MyOrderItem> deleteMyOrderItemByIdOrderItem(Integer idOrderItem);


}
