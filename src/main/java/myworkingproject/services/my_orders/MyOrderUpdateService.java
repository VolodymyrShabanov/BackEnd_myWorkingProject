package myworkingproject.services.my_orders;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myworkingproject.dto.my_order_items.MyOrderItemRequestDto;
import myworkingproject.dto.my_orders.MyOrderByIdResponseDto;
import myworkingproject.dto.my_orders.MyOrderResponseDto;
import myworkingproject.entitys.MyOrder;
import myworkingproject.entitys.MyOrderItem;
import myworkingproject.entitys.OrderStatus;
import myworkingproject.repositories.MyOrderRepository;
import myworkingproject.services.converters.MyOrderConverter;
import myworkingproject.services.exeptions.AlreadyExistException;
import myworkingproject.services.exeptions.IllegalArgumentException;
import myworkingproject.services.exeptions.NotFoundException;
import myworkingproject.services.my_order_items.MyOrderItemCreateService;
import myworkingproject.services.my_order_items.MyOrderItemFindService;
import myworkingproject.services.my_order_items.MyOrderItemUpdateService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class MyOrderUpdateService {
    private final MyOrderRepository myOrderRepository;
    private MyOrderConverter myOrderConverter;
    private MyOrderItemCreateService myOrderItemCreateService;
    private MyOrderItemUpdateService myOrderItemUpdateService;
    private MyOrderItemFindService myOrderItemFindService;

    public MyOrderResponseDto updateOrderById(Integer idOrder, String status, String description) {
        MyOrder foundMyOrder = myOrderRepository.findById(idOrder)
                .orElseThrow(() -> new NotFoundException("Order with id: " + idOrder + " not found"));

        if (status != null) {
            foundMyOrder.setStatus(OrderStatus.fromString(status));
        }

        if (description != null) {
            foundMyOrder.setDescription(description);
        }

        foundMyOrder.setLastUpdate(LocalDateTime.now());

        return myOrderConverter.toResponse(myOrderRepository.save(foundMyOrder));
    }

    public MyOrderByIdResponseDto addItemToOrder(MyOrderItemRequestDto request) {
        MyOrder foundMyOrder = myOrderRepository.findById(request.getIdMyOrder())
                .orElseThrow(() -> new NotFoundException("Order with id: " + request.getIdMyOrder() + " not found"));


        if (foundMyOrder.getMyOrderItemsList().stream()
                .anyMatch(myOrderItem -> myOrderItem.getSparePart().getIdSparePart().equals(request.getIdSparePart()))) {
            throw new AlreadyExistException("Order Item with id: " + request.getIdSparePart() + " already exist!");
        }

        myOrderItemCreateService.createMyOrderItem(request);

        foundMyOrder.setLastUpdate(LocalDateTime.now());

        return myOrderConverter.toByIdResponse(myOrderRepository.save(foundMyOrder));
    }

    public MyOrderByIdResponseDto updateQuantityItemToOrder(Integer idMyOrder, Integer idMyOrderItem, Integer quantity) {
        MyOrder foundMyOrder = myOrderRepository.findById(idMyOrder)
                .orElseThrow(() -> new NotFoundException("Order with id: " + idMyOrder + " not found"));

        if (myOrderItemFindService.findByIdReturnOrderItem(idMyOrderItem).getMyOrder().equals(foundMyOrder)) {
            myOrderItemUpdateService.updateMyOrderItemById(idMyOrderItem, quantity);

            foundMyOrder.setLastUpdate(LocalDateTime.now());

            return myOrderConverter.toByIdResponse(myOrderRepository.save(foundMyOrder));

        } else {
            throw new IllegalArgumentException("There is no idOrderItem: " + idMyOrderItem + " in the Order with id: " + idMyOrder);
        }
    }

    public MyOrderByIdResponseDto deleteMyOrderItemFromMyOrder(Integer idMyOrder, Integer idMyOrderItem) {
        MyOrder foundOrder = myOrderRepository.findById(idMyOrder)
                .orElseThrow(() -> new NotFoundException("Order with id: " + idMyOrder + " not found"));

        MyOrderItem foundOrderItem = myOrderItemFindService.findByIdReturnOrderItem(idMyOrderItem);

        if (foundOrderItem.getMyOrder().equals(foundOrder)) {

            foundOrder.getMyOrderItemsList().remove(foundOrderItem);

            foundOrder.setLastUpdate(LocalDateTime.now());

            return myOrderConverter.toByIdResponse(myOrderRepository.save(foundOrder));

        } else {
            throw new IllegalArgumentException("There is no idOrderItem: " + idMyOrderItem + " in the Order with id: " + idMyOrder);
        }
    }
}
