package antonburshteyn.payment.service;

import antonburshteyn.payment.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    @Override
    public Boolean addPayment(String id, PaymentDto paymentDto) {
        return null;
    }

    @Override
    public Boolean updatePayment(String id, PaymentDto paymentDto) {
        return null;
    }

    @Override
    public PaymentDto getPaymentById(String paymentId) {
        return null;
    }
}
