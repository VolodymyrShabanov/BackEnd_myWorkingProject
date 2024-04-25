package myworkingproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myworkingproject.service.exeption.CalculateException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSparePart;
    private String name;
    private Integer quantity;
    private String description;


    public Integer takeQuantity(Integer quantity) {

        if (quantity < 0) {
            throw new IllegalArgumentException("The value quantity cannot be less than 0");
        }

        if (this.quantity >= quantity) {
            return this.quantity -= quantity;
        } else {
            throw new CalculateException("Not enough spare parts, the balance: " + this.quantity);
        }
    }

    public Integer putQuantity(Integer quantity){

        if (quantity < 0) {
            throw new IllegalArgumentException("The value quantity cannot be less than 0");
        }

       return this.quantity += quantity;
    }
}
