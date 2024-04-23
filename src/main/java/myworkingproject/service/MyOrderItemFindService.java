package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemResponseDto;
import myworkingproject.entity.MyOrderItem;
import myworkingproject.repository.MyOrderItemRepository;
import myworkingproject.service.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyOrderItemFindService {
    private final MyOrderItemRepository myOrderItemRepository;

    public List<MyOrderItemResponseDto> findAll(){
        return myOrderItemRepository.findAll().stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

    public MyOrderItemResponseDto findById(Integer idOrderItem){
        MyOrderItem orderItem = myOrderItemRepository.findById(idOrderItem)
                .orElseThrow(() -> new NotFoundException("Order item with id: " + idOrderItem + " not found!"));

        return MyOrderItemResponseDto.toResponse(orderItem);
    }

    public List<MyOrderItemResponseDto> findByIdSparePart(Integer idSparePart){
        return myOrderItemRepository.findBySparePartIdSparePart(idSparePart).stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

    public List<MyOrderItemResponseDto> findByIdMyOrder(Integer idMyOrder){
        return myOrderItemRepository.findByMyOrder_IdOrder(idMyOrder).stream()
                .map(MyOrderItemResponseDto::toResponse)
                .toList();
    }

}
