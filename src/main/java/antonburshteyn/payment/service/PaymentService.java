package antonburshteyn.payment.service;

import antonburshteyn.payment.dto.PaymentDto;

public interface PaymentService {

    Boolean addPayment(String id, PaymentDto paymentDto);

    Boolean updatePayment(String id, PaymentDto paymentDto);

    PaymentDto getPaymentById(String paymentId);
}
