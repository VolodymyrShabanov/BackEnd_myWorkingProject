package myworkingproject.dto.my_order_items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entitys.MyOrderItem;

@Data
@AllArgsConstructor
@Builder
public class MyOrderItemResponseDto {
    private Integer idMyOrderItem;
    private Integer idSparePart;
    private Integer idMyOrder;
    private Integer quantity;

    public static MyOrderItemResponseDto toResponse(MyOrderItem myOrderItem) {
        return MyOrderItemResponseDto.builder()
                .idMyOrderItem(myOrderItem.getIdMyOrderItem())
                .idSparePart(myOrderItem.getSparePart().getIdSparePart())
                .idMyOrder(myOrderItem.getMyOrder().getIdMyOrder())
                .quantity(myOrderItem.getQuantity())
                .build();
    }
}
