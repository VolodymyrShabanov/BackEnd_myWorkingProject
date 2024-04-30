package myworkingproject.services.my_order_items;

import lombok.AllArgsConstructor;
import myworkingproject.entitys.MyOrderItem;
import myworkingproject.entitys.SparePart;
import myworkingproject.repositories.MyOrderItemRepository;
import myworkingproject.services.exeptions.CalculateException;
import myworkingproject.services.exeptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderItemUpdateService {
    private final MyOrderItemRepository myOrderItemRepository;

    public void updateMyOrderItemById(Integer idMyOrderItem, Integer quantity) {
        MyOrderItem foundMyOrderItem = myOrderItemRepository.findByIdMyOrderItem(idMyOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + idMyOrderItem + " not found!"));

        SparePart sparePart = foundMyOrderItem.getSparePart();
        Integer surplus = sparePart.getQuantity();
        Integer reserved = foundMyOrderItem.getQuantity();
        Integer balance = surplus + reserved;

        if (quantity < 0) {
            throw new IllegalArgumentException("The value quantity cannot be less than 0");
        }

        if (quantity.equals(reserved)) {
            return;
        }

        if (quantity > balance) {
            throw new CalculateException("Not enough spare parts. Surplus: " + surplus +
                    ", in Order item id: " + foundMyOrderItem.getIdMyOrderItem() +
                    " reserved: " + reserved + " (summary balance: " + balance + ")");
        }

        sparePart.setQuantity(balance - quantity);
        foundMyOrderItem.setQuantity(quantity);

    }
}
