package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.services.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MessageController {

    private final MessageService messageService;

    @RequestMapping(value = "/send", method = RequestMethod.POST, //
            consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String send(HttpEntity<String> httpEntity) {
        String message = httpEntity.getBody();
        log.info(message);

        messageService.sendWhatsappMessage("deluxe-ankle", "5551980175570", message);

        return "";
    }

}