package myworkingproject.service.myOrderItem;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemResponseDto;
import myworkingproject.entity.MyOrderItem;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.MyOrderItemRepository;
import myworkingproject.service.exeption.CalculateException;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MyOrderItemUpdateService {
    private final MyOrderItemRepository myOrderItemRepository;

    public MyOrderItemResponseDto updateMyOrderItemById(Integer idMyOrderItem, Integer quantity) {
        MyOrderItem updateMyOrderItem = myOrderItemRepository.findByIdOrderItem(idMyOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + idMyOrderItem + " not found!"));

        SparePart sparePart = updateMyOrderItem.getSparePart();
        Integer surplus = sparePart.getQuantity();
        Integer reserved = updateMyOrderItem.getQuantity();
        Integer balance = surplus + reserved;

        if (quantity < 0) {
            throw new IllegalArgumentException("The value quantity cannot be less than 0");
        }

        if (quantity.equals(reserved)) {
            return MyOrderItemResponseDto.toResponse(updateMyOrderItem);
        }

        if (quantity > balance) {
            throw new CalculateException("Not enough spare parts. Surplus: " + surplus +
                    ", in Order item id: " + updateMyOrderItem.getIdOrderItem() +
                    " reserved: " +  reserved + " (summary balance: " + balance + ")");
        }

        sparePart.setQuantity(balance - quantity);
        updateMyOrderItem.setQuantity(quantity);

        return MyOrderItemResponseDto.toResponse(updateMyOrderItem);
    }


    public void deleteOrderItem(Integer myOrderItem){
        myOrderItemRepository.deleteMyOrderItemByIdOrderItem(myOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + myOrderItem + " not found!"));

    }

}
