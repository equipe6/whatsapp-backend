package br.edu.unisinos.whatsapp.services;

import br.edu.unisinos.whatsapp.entities.WebhookMessage;
import br.edu.unisinos.whatsapp.repositories.WebhookMessageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class WebhookMessageService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final transient WebhookMessageRepository webhookMessageRepository;

    public WebhookMessage save(String StrWebhookMessage) {
        WebhookMessage webhookMessage = new WebhookMessage();
        webhookMessage.setContentBody(StrWebhookMessage);
        return this.save(webhookMessage);
    }

    public WebhookMessage save(WebhookMessage webhookMessage) {
        return webhookMessageRepository.save(webhookMessage);
    }
}
