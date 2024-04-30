package myworkingproject.services.converters;

import myworkingproject.dto.my_orders.MyOrderByIdResponseDto;
import myworkingproject.dto.my_orders.MyOrderItemListDto;
import myworkingproject.dto.my_orders.MyOrderRequestDto;
import myworkingproject.dto.my_orders.MyOrderResponseDto;
import myworkingproject.entitys.Auto;
import myworkingproject.entitys.MyOrder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MyOrderConverter {

    public MyOrder fromRequest(MyOrderRequestDto request, Auto auto) {
        MyOrder newMyOrder = new MyOrder();
        newMyOrder.setAuto(auto);
        newMyOrder.setCreateDate(LocalDateTime.now());
        newMyOrder.setLastUpdate(LocalDateTime.now());
        newMyOrder.setDescription(request.getDescription());

        return newMyOrder;
    }

    public MyOrderResponseDto toResponse(MyOrder myOrder) {

        return new MyOrderResponseDto(
                myOrder.getIdMyOrder(),
                myOrder.getAuto().getIdAuto(),
                myOrder.getCreateDate(),
                myOrder.getLastUpdate(),
                myOrder.getStatus(),
                myOrder.getDescription()
        );
    }

    public MyOrderByIdResponseDto toByIdResponse(MyOrder myOrder) {

        List<MyOrderItemListDto> spareParts = myOrder.getMyOrderItemsList().stream()
                .map(myOrderItem -> new MyOrderItemListDto(myOrderItem.getIdMyOrderItem(),
                        myOrderItem.getSparePart().getIdSparePart(),
                        myOrderItem.getSparePart().getName(),
                        myOrderItem.getQuantity())).toList();

        return MyOrderByIdResponseDto.builder()
                .idMyOrder(myOrder.getIdMyOrder())
                .idAuto(myOrder.getAuto().getIdAuto())
                .myOrderItemsList(spareParts)
                .createDate(myOrder.getCreateDate())
                .lastUpdate(myOrder.getLastUpdate())
                .status(myOrder.getStatus())
                .description(myOrder.getDescription())
                .build();

    }
}
