package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.dto.myOrderItemDto.MyOrderItemRequestDto;
import myworkingproject.dto.orderDto.MyOrderByIdResponseDto;
import myworkingproject.entity.MyOrder;
import myworkingproject.repository.MyOrderRepository;
import myworkingproject.service.exeption.IllegalArgumentException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderUpdateService {

    private final MyOrderRepository myOrderRepository;
    private final MyOrderItemCreateService myOrderItemCreateService;
    private final MyOrderItemFindService myOrderItemFindService;

}
