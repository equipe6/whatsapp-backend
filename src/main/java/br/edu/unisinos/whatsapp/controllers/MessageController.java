package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.dtos.MessageSendDto;
import br.edu.unisinos.whatsapp.entities.Message;
import br.edu.unisinos.whatsapp.services.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MessageController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final MessageService messageService;

    @PostMapping(value = "/send/{phoneNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String send(HttpEntity<MessageSendDto> httpEntity, @PathVariable("phoneNumber") String phoneNumber) {
        MessageSendDto dto = httpEntity.getBody();
        log.info(dto);

        messageService.sendWhatsappMessage("deluxe-ankle", phoneNumber, dto.getMessage());

        return "";
    }

    @GetMapping(value = "/channel/{channel}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Message> listMessagesByChannel(@PathVariable("channel") String channel) {
        return messageService.listMessagesByChannel(channel);
    }

    @GetMapping(value = "/channels", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> listAllChannel() {
        return messageService.listAllChannel();
    }


}