//package drafts;
//
//import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
//import myworkingproject.dto.orderDto.MyOrderItemListDto;
//import myworkingproject.dto.orderDto.MyOrderRequestDto;
//import myworkingproject.dto.orderDto.MyOrderResponseDto;
//import myworkingproject.entity.Auto;
//import myworkingproject.entity.MyOrder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class MyOrderConverter {
//
//    public MyOrder fromRequest(MyOrderRequestDto request, Auto findAuto) {
//        MyOrder newMyOrder = new MyOrder();
//        newMyOrder.setAuto(findAuto);
//        newMyOrder.setCreateDate(LocalDateTime.now());
//        newMyOrder.setLastUpdate(LocalDateTime.now());
//        newMyOrder.setDescription(request.getDescription());
//
//        return newMyOrder;
//    }
//
//    public MyOrderResponseDto toResponse(MyOrder myOrder) {
//
//        return new MyOrderResponseDto(
//                myOrder.getIdOrder(),
//                myOrder.getAuto().getIdAuto(),
//                myOrder.getCreateDate(),
//                myOrder.getLastUpdate(),
//                myOrder.getStatus(),
//                myOrder.getDescription()
//        );
//
////        return MyOrderCreateResponseDto.builder()
////                .idOrder(myOrder.getIdOrder())
////                .idAuto(idAuto)
////                .createDate(myOrder.getCreateDate())
////                .lastUpdate(myOrder.getLastUpdate())
////                .status(myOrder.getStatus())
////                .description(myOrder.getDescription())
////                .build();
//    }
//
//    public MyOrderByIdResponseDto toByIdResponse(MyOrder myOrder) {
////        List<MyOrderListSparePartDto> spareParts = new ArrayList<>();
//
////        for (Map.Entry<SparePart, Integer> entry : myOrder.getSpareParts().entrySet()) {
////            SparePart sparePart = entry.getKey();
////            Integer quantity = entry.getValue();
////
////            spareParts.add(new MyOrderListSparePartDto(sparePart.getIdSparePart(), sparePart.getName(), quantity));
////        }
//
//        List<MyOrderItemListDto> spareParts = myOrder.getMyOrderItemList().stream()
//                .map(spq -> new MyOrderItemListDto(spq.getSparePart().getIdSparePart(),
//                                    spq.getSparePart().getName(),
//                                    spq.getQuantity())).toList();
//
//        return MyOrderByIdResponseDto.builder()
//                .idOrder(myOrder.getIdOrder())
//                .idAuto(myOrder.getAuto().getIdAuto())
//
//                .sparePartsList(spareParts)
//
//                .createDate(myOrder.getCreateDate())
//                .lastUpdate(myOrder.getLastUpdate())
//                .status(myOrder.getStatus())
//                .description(myOrder.getDescription())
//                .build();
//
//    }
//}
