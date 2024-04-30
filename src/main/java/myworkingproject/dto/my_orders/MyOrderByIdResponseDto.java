package myworkingproject.dto.my_orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entitys.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
public class MyOrderByIdResponseDto {

    private Integer idMyOrder;
    private Integer idAuto;
    private List<MyOrderItemListDto> myOrderItemsList;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private OrderStatus status;
    private String description;

}


