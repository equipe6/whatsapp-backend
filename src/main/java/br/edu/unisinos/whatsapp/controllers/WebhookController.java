package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.enums.DirectionEnum;
import br.edu.unisinos.whatsapp.services.MessageService;
import br.edu.unisinos.whatsapp.services.WebhookMessageService;
import com.zenvia.api.sdk.webhook.MessageEvent;
import com.zenvia.api.sdk.webhook.MessageStatusEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Log4j2
@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class WebhookController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final WebhookMessageService webhookMessageService;

    private final MessageService messageService;

    @RequestMapping(value = "/message", method = RequestMethod.POST, //
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String message(HttpEntity<MessageEvent> httpEntity) {
        MessageEvent messageEvent = httpEntity.getBody();
        if (messageEvent != null) {
            String json = messageEvent.toString();

            log.info(json);
            webhookMessageService.save(json);

            messageService.save(messageEvent, DirectionEnum.IN);
        }
        return "";
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST, //
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String status(HttpEntity<MessageStatusEvent> httpEntity) {
        MessageStatusEvent messageStatusEvent = httpEntity.getBody();
        if (messageStatusEvent != null) {
            String json = messageStatusEvent.toString();

            log.info(json);
            webhookMessageService.save(json);
        }
        return "";
    }
}