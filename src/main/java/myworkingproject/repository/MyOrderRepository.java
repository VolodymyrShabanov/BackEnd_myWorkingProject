package myworkingproject.repository;

import myworkingproject.entity.Auto;
import myworkingproject.entity.MyOrder;
import myworkingproject.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
    Optional<MyOrder> findById (Integer idOrder);

    List<MyOrder> findByAuto(Auto auto);

    List<MyOrder> findByCreateDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<MyOrder> findByStatus(OrderStatus status);
}
