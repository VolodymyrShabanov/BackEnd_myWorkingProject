package myworkingproject.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
public class MyOrderByIdResponseDto {
    private Integer idOrder;
    private Integer idAuto;
    private List<MyOrderListSparePartDto> sparePartsList;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private OrderStatus status;
    private String description;
}


