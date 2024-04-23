package myworkingproject.dto.myOrderItemDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import myworkingproject.entity.MyOrderItem;

@Data
@AllArgsConstructor
@Builder
public class MyOrderItemResponseDto {
    private Integer idOrderItem;
    private Integer idSparePart;
    private Integer idMyOrder;
    private Integer quantity;

    public static MyOrderItemResponseDto toResponse(MyOrderItem myOrderItem) {
        return MyOrderItemResponseDto.builder()
                .idOrderItem(myOrderItem.getIdOrderItem())
                .idSparePart(myOrderItem.getSparePart().getIdSparePart())
                .idMyOrder(myOrderItem.getMyOrder().getIdOrder())
                .quantity(myOrderItem.getQuantity())
                .build();
    }
}
