//package drafts;
//
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import myworkingproject.dto.my_order_items.MyOrderItemRequestDto;
//import myworkingproject.dto.my_orders.MyOrderByIdResponseDto;
//import myworkingproject.dto.my_orders.MyOrderResponseDto;
//import myworkingproject.entitys.MyOrder;
//import myworkingproject.entitys.MyOrderItem;
//import myworkingproject.entitys.OrderStatus;
//import myworkingproject.repositories.MyOrderRepository;
//import myworkingproject.services.converters.MyOrderConverter;
//import myworkingproject.services.exeptions.IllegalArgumentException;
//import myworkingproject.services.exeptions.NotFoundException;
//import myworkingproject.services.my_order_items.MyOrderItemCreateService;
//import myworkingproject.services.my_order_items.MyOrderItemFindService;
//import myworkingproject.services.my_order_items.MyOrderItemUpdateService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class MyOrderUpdateService {
//    private final MyOrderRepository myOrderRepository;
//    private MyOrderConverter myOrderConverter;
//    private MyOrderItemCreateService myOrderItemCreateService;
//    private MyOrderItemUpdateService myOrderItemUpdateService;
//    private MyOrderItemFindService myOrderItemFindService;
//
//    public MyOrderResponseDto updateOrderById(Integer idOrder, String status, String description) {
//        MyOrder updateOrder = myOrderRepository.findById(idOrder)
//                .orElseThrow(() -> new NotFoundException("Order with id: " + idOrder + " not found"));
//
//        if (status != null) {
//            updateOrder.setStatus(OrderStatus.fromString(status));
//        }
//
//        if (description != null) {
//            updateOrder.setDescription(description);
//        }
//
//        updateOrder.setLastUpdate(LocalDateTime.now());
//
//        return myOrderConverter.toResponse(myOrderRepository.save(updateOrder));
//
//    }
//
//    public MyOrderByIdResponseDto addItemToOrder(MyOrderItemRequestDto request) {
//        MyOrder updateOrder = myOrderRepository.findById(request.getIdMyOrder())
//                .orElseThrow(() -> new NotFoundException("Order with id: " + request.getIdMyOrder() + " not found"));
//
//        myOrderItemCreateService.createMyOrderItem(request);
//
//        updateOrder.setLastUpdate(LocalDateTime.now());
//
//        return myOrderConverter.toByIdResponse(myOrderRepository.save(updateOrder));
//    }
//
//    public MyOrderByIdResponseDto updateQuantityItemToOrder(Integer idOrder, Integer idOrderItem, Integer quantity) {
//        MyOrder updateOrder = myOrderRepository.findById(idOrder)
//                .orElseThrow(() -> new NotFoundException("Order with id: " + idOrder + " not found"));
//
//        if (myOrderItemFindService.findByIdReturnOrderItem(idOrderItem).getMyOrder().equals(updateOrder)) {
//            myOrderItemUpdateService.updateMyOrderItemById(idOrderItem, quantity);
//
//            updateOrder.setLastUpdate(LocalDateTime.now());
//
//            return myOrderConverter.toByIdResponse(myOrderRepository.save(updateOrder));
//
//        } else {
//            throw new IllegalArgumentException("There is no idOrderItem: " + idOrderItem + " in the Order with id: " + idOrder);
//        }
//
//    }
//
//
////    public MyOrderByIdResponseDto deleteItemToOrder(Integer idOrder, Integer idOrderItem) {
////        MyOrder foundOrder = myOrderRepository.findById(idOrder)
////                .orElseThrow(() -> new NotFoundException("Order with id: " + idOrder + " not found"));
////
////        MyOrderItem foundOrderItem = myOrderItemFindService.findByIdReturnOrderItem(idOrderItem);
////
////        if (foundOrderItem.getMyOrder().equals(foundOrder)) {
////
////            myOrderItemUpdateService.deleteOrderItem(foundOrderItem.getIdOrderItem());
////
////            foundOrder.setLastUpdate(LocalDateTime.now());
////
////            return myOrderConverter.toByIdResponse(myOrderRepository.save(foundOrder));
////
////        } else {
////            throw new IllegalArgumentException("There is no idOrderItem: " + idOrderItem + " in the Order with id: " + idOrder);
////        }
////    }
//
//    @Transactional
//    public MyOrderByIdResponseDto deleteItemToOrder(Integer idOrderItem) {
//
//        MyOrderItem foundOrderItem = myOrderItemFindService.findByIdReturnOrderItem(idOrderItem);
//
//        MyOrder foundMyOrder = foundOrderItem.getMyOrder();
//
//        foundMyOrder.getMyOrderItemsList().remove(foundOrderItem);
//
//
//        log.info(String.valueOf(foundOrderItem));
//        log.info(String.valueOf(foundMyOrder));
//
////        myOrderItemUpdateService.deleteOrderItem(idOrderItem);
//
//        return myOrderConverter.toByIdResponse(myOrderRepository.save(foundMyOrder));
//    }
//
//}
