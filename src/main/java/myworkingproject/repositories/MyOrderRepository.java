package myworkingproject.repositories;

import myworkingproject.entitys.Auto;
import myworkingproject.entitys.MyOrder;
import myworkingproject.entitys.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
    Optional<MyOrder> findByIdMyOrder(Integer idMyOrder);

    List<MyOrder> findByAuto(Auto auto);

    List<MyOrder> findByCreateDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<MyOrder> findByStatus(OrderStatus status);
}
