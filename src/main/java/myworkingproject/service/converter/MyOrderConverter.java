package myworkingproject.service.converter;

import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.dto.orderDto.MyOrderItemListDto;
import myworkingproject.dto.orderDto.MyOrderRequestDto;
import myworkingproject.dto.orderDto.MyOrderResponseDto;
import myworkingproject.entity.Auto;
import myworkingproject.entity.MyOrder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MyOrderConverter {

    public MyOrder fromRequest(MyOrderRequestDto request, Auto findAuto) {
        MyOrder newMyOrder = new MyOrder();
        newMyOrder.setAuto(findAuto);
        newMyOrder.setCreateDate(LocalDateTime.now());
        newMyOrder.setLastUpdate(LocalDateTime.now());
        newMyOrder.setDescription(request.getDescription());

        return newMyOrder;
    }

    public MyOrderResponseDto toResponse(MyOrder myOrder) {

        return new MyOrderResponseDto(
                myOrder.getIdOrder(),
                myOrder.getAuto().getIdAuto(),
                myOrder.getCreateDate(),
                myOrder.getLastUpdate(),
                myOrder.getStatus(),
                myOrder.getDescription()
        );
    }

    public MyOrderByIdResponseDto toByIdResponse(MyOrder myOrder) {

        List<MyOrderItemListDto> spareParts = myOrder.getMyOrderItemList().stream()
                .map(myOrderItem -> new MyOrderItemListDto(myOrderItem.getSparePart().getIdSparePart(),
                                    myOrderItem.getSparePart().getName(),
                                    myOrderItem.getQuantity())).toList();

        return MyOrderByIdResponseDto.builder()
                .idOrder(myOrder.getIdOrder())
                .idAuto(myOrder.getAuto().getIdAuto())

                .orderItemsList(spareParts)

                .createDate(myOrder.getCreateDate())
                .lastUpdate(myOrder.getLastUpdate())
                .status(myOrder.getStatus())
                .description(myOrder.getDescription())
                .build();

    }
}
