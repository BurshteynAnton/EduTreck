package antonburshteyn.payment.controller;

import antonburshteyn.payment.dto.PaymentDto;
import antonburshteyn.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    final PaymentService paymentService;

    @PostMapping("/student/{id}/payment")
    public Boolean addPayment(@PathVariable String id,@RequestBody PaymentDto paymentDto) {
        return paymentService.addPayment(id, paymentDto);
    }

    @PutMapping("/student/{id}/payment")
    public Boolean updatePayment(@PathVariable String id,@RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(id, paymentDto);
    }

    @GetMapping("/payment/{paymentId}")
    public PaymentDto getPaymentById(@RequestBody String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }
}
