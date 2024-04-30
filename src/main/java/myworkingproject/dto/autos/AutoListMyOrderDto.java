package myworkingproject.dto.autos;

import lombok.AllArgsConstructor;
import lombok.Data;
import myworkingproject.entitys.OrderStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AutoListMyOrderDto {
    private Integer idOrder;
    private LocalDateTime lastUpdate;
    private OrderStatus status;
    private String description;
}
