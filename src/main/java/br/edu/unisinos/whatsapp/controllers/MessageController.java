package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.entities.Message;
import br.edu.unisinos.whatsapp.services.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/send", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String send(HttpEntity<String> httpEntity) {
        String message = httpEntity.getBody();
        log.info(message);

        messageService.sendWhatsappMessage("deluxe-ankle", "5551980175570", message);

        return "";
    }

    @GetMapping(value = "/channel/{channel}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Message> listMessagesByChannel(@PathVariable("channel") String channel) {
        return messageService.listMessagesByChannel(channel);
    }


}