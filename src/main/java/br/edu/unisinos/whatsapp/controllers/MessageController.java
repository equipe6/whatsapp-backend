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
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String send(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        log.info(json);

        return "";
    }

}