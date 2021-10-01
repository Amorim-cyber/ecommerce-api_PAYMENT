package br.com.ecommerce.payment.listener;

import br.com.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.ecommerce.payment.event.PaymentCreatedEvent;
import br.com.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event){
        // Processa pagamento gateway
        // Salva dados de pagamento
        // Enviar o evento do pagamento

        final PaymentCreatedEvent paymentCreatedEvent =  PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setCheckoutStatus(event.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();

        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }

}
