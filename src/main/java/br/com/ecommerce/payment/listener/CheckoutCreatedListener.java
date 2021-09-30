package br.com.ecommerce.payment.listener;

import br.com.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.ecommerce.payment.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class CheckoutCreatedListener {

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event){
        // Processa pagamento gateway
        // Salva dados de pagamento
        // Enviar o evento do pagamento
    }

}
