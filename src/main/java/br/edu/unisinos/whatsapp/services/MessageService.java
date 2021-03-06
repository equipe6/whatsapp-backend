package br.edu.unisinos.whatsapp.services;

import br.edu.unisinos.whatsapp.entities.Message;
import br.edu.unisinos.whatsapp.enums.DirectionEnum;
import br.edu.unisinos.whatsapp.repositories.MessageRepository;
import com.zenvia.api.sdk.client.Channel;
import com.zenvia.api.sdk.client.errors.ErrorResponse;
import com.zenvia.api.sdk.client.exceptions.ApiException;
import com.zenvia.api.sdk.client.exceptions.UnsuccessfulRequestException;
import com.zenvia.api.sdk.client.spring.Client;
import com.zenvia.api.sdk.contents.Content;
import com.zenvia.api.sdk.contents.TextContent;
import com.zenvia.api.sdk.webhook.MessageEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MessageService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final transient MessageRepository messageRepository;

    public Message save(MessageEvent messageEvent, DirectionEnum direction) {
        Message message = new Message();
        message.setFrom(messageEvent.message.from);
        message.setTo(messageEvent.message.to);
        message.setBody(messageEvent.message.contents.get(0).ofText().text);
        message.setDirection(direction);

        return this.save(message);
    }

    public Message save(String from, String to, String messageText, DirectionEnum direction) {
        Message message = new Message();
        message.setFrom(from);
        message.setTo(to);
        message.setBody(messageText);
        message.setDirection(direction);

        return this.save(message);
    }

    public Message save(Message message) {
        message.buildChannel();
        return this.messageRepository.save(message);
    }

    public Message sendWhatsappMessage(String from, String to, String messageText) {
        try (Client client = this.buildZenviaClient()) {

            Channel whatsapp = client.getChannel("whatsapp");
            Content content = new TextContent(messageText);

            try {
                whatsapp.sendMessage(from, to, content);
            } catch (UnsuccessfulRequestException exception) {
                ErrorResponse response = exception.body;
                log.error(response);
                throw exception;
            } catch (ApiException exception) {
                log.error(exception);
                throw exception;
            }
        }

        return this.save(from, to, messageText, DirectionEnum.OUT);
    }

    public List<Message> listMessagesByChannel(String channel) {
        return this.messageRepository.findAllByChannelOrderByCreateDateTimeAsc(channel);
    }

    public List<String> listAllChannel() {
        return this.messageRepository.findDistinctChannel();
    }

    Client buildZenviaClient() {
        return new Client("os-SvXSoEHI3ECnG5-kxn1EX11qrwexxURhI");
    }
}
