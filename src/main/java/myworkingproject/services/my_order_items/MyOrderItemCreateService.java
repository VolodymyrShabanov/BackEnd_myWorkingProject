package myworkingproject.services.my_order_items;

import lombok.AllArgsConstructor;
import myworkingproject.dto.my_order_items.MyOrderItemRequestDto;
import myworkingproject.dto.my_order_items.MyOrderItemResponseDto;
import myworkingproject.entitys.MyOrder;
import myworkingproject.entitys.MyOrderItem;
import myworkingproject.entitys.SparePart;
import myworkingproject.repositories.MyOrderItemRepository;
import myworkingproject.services.my_orders.MyOrderFindService;
import myworkingproject.services.spare_parts.SparePartFindService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderItemCreateService {
    private final MyOrderItemRepository myOrderItemRepository;
    private SparePartFindService sparePartFindService;
    private MyOrderFindService myOrderFindService;

    public void createMyOrderItem(MyOrderItemRequestDto request) {

            Integer idSparePart = request.getIdSparePart();
            Integer idMyOrder = request.getIdMyOrder();
            Integer quantity = request.getQuantity();

            SparePart sparePart = sparePartFindService.findByIdReturnSparePart(idSparePart);
            MyOrder myOrder = myOrderFindService.findByIdReturnMyOrder(idMyOrder);

            sparePart.takeQuantity(quantity);

            MyOrderItem newMyOrderItem = MyOrderItem.builder()
                    .quantity(quantity)
                    .sparePart(sparePart)
                    .myOrder(myOrder)
                    .build();

            MyOrderItemResponseDto.toResponse(myOrderItemRepository.save(newMyOrderItem));

    }

    public MyOrderItemResponseDto createMyOrderItem(Integer idOrder, Integer idSparePart, Integer quantity) {

        SparePart sparePart = sparePartFindService.findByIdReturnSparePart(idSparePart);
        MyOrder myOrder = myOrderFindService.findByIdReturnMyOrder(idOrder);

        sparePart.takeQuantity(quantity);

        MyOrderItem newMyOrderItem = MyOrderItem.builder()
                .quantity(quantity)
                .sparePart(sparePart)
                .myOrder(myOrder)
                .build();

        return MyOrderItemResponseDto.toResponse(myOrderItemRepository.save(newMyOrderItem));
    }

}
