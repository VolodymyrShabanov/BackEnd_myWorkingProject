package myworkingproject.service;

import lombok.AllArgsConstructor;
import myworkingproject.entity.SparePart;
import myworkingproject.repository.SparePartRepository;
import myworkingproject.service.exeption.CalculateException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SparePartChangeService {
    private final SparePartRepository sparePartRepository;

    public SparePart take(SparePart sparePart, Integer quantity) {
        Integer balance = sparePart.getQuantity();

        if (balance < quantity) {
            throw new CalculateException("Not enough spare parts, the balance: " + balance);
        }

        sparePart.setQuantity(balance - quantity);
        return sparePart;
    }

}
