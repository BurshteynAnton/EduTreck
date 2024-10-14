package antonburshteyn.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    Enum<?>Credit;
    Double amount;
    Double installments;
    Double each;
}
