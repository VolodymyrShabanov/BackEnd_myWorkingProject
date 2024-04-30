package myworkingproject.services.my_order_items;

import lombok.AllArgsConstructor;
import myworkingproject.dto.my_order_items.MyOrderItemResponseDto;
import myworkingproject.entitys.MyOrderItem;
import myworkingproject.repositories.MyOrderItemRepository;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyOrderItemFindService {
    private final MyOrderItemRepository myOrderItemRepository;

    public List<MyOrderItemResponseDto> findAll() {
        return myOrderItemRepository.findAll().stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

    public MyOrderItemResponseDto findById(Integer idOrderItem) {
        MyOrderItem orderItem = myOrderItemRepository.findById(idOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + idOrderItem + " not found!"));

        return MyOrderItemResponseDto.toResponse(orderItem);
    }

    public MyOrderItem findByIdReturnOrderItem(Integer idOrderItem) {
        return myOrderItemRepository.findById(idOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + idOrderItem + " not found!"));
    }


    public List<MyOrderItemResponseDto> findByIdSparePart(Integer idSparePart) {
        return myOrderItemRepository.findBySparePartIdSparePart(idSparePart).stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

    public List<MyOrderItemResponseDto> findByIdMyOrder(Integer idMyOrder) {
        return myOrderItemRepository.findByMyOrder_IdMyOrder(idMyOrder).stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

}
