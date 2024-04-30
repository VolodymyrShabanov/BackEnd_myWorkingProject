package myworkingproject.services.my_orders;

import lombok.AllArgsConstructor;
import myworkingproject.dto.my_orders.MyOrderRequestDto;
import myworkingproject.dto.my_orders.MyOrderResponseDto;
import myworkingproject.entitys.Auto;
import myworkingproject.entitys.MyOrder;
import myworkingproject.repositories.MyOrderRepository;
import myworkingproject.services.autos.AutoFindService;
import myworkingproject.services.converters.MyOrderConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyOrderCreateService {
    private final MyOrderRepository myOrderRepository;
    private MyOrderConverter myOrderConverter;
    private AutoFindService autoFindService;

    public MyOrderResponseDto createMyOrder(MyOrderRequestDto request){

        Integer idAutoFromRequest = request.getIdAuto();

        Auto foundAuto = autoFindService.findByIdReturnAuto(idAutoFromRequest);

        MyOrder newMyOrder = myOrderConverter.fromRequest(request, foundAuto);

        return myOrderConverter.toResponse(myOrderRepository.save(newMyOrder));
    }
}
