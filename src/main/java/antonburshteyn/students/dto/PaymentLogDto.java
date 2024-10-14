package antonburshteyn.students.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentLogDto {
        Long id;
        String type;
        Double amount;
        String installments;
        String each;
}
