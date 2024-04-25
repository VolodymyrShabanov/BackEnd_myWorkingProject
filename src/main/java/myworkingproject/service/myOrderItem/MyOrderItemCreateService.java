package myworkingproject.service.myOrderItem;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemRequestDto;
import myworkingproject.dto.myOrderItemDto.MyOrderItemResponseDto;
import myworkingproject.entity.MyOrder;
import myworkingproject.entity.MyOrderItem;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.MyOrderItemRepository;
import myworkingproject.service.myOrder.MyOrderFindService;
import myworkingproject.service.sparePart.SparePartFindService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderItemCreateService {
    private final MyOrderItemRepository myOrderItemRepository;
    private SparePartFindService sparePartFindService;
    private MyOrderFindService myOrderFindService;

    public MyOrderItemResponseDto createOrderItem(MyOrderItemRequestDto request) {
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

        return MyOrderItemResponseDto.toResponse(myOrderItemRepository.save(newMyOrderItem));
    }

    public MyOrderItemResponseDto createOrderItem(Integer idOrder, Integer idSparePart, Integer quantity) {

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
