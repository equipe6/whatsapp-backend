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

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MessageService {

    private final MessageRepository messageRepository;


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
        // Initialization with your API token (x-api-token)
        Client client = new Client("os-SvXSoEHI3ECnG5-kxn1EX11qrwexxURhI");

        // Choosing the channel
        Channel whatsapp = client.getChannel("whatsapp");

        // Creating a text content
        Content content = new TextContent(messageText);

        try {
            com.zenvia.api.sdk.messages.Message response = whatsapp.sendMessage(from, to, content);
            // do something here
        } catch (UnsuccessfulRequestException exception) {
            ErrorResponse response = exception.body;
            // handle error here
        } catch (ApiException exception) {
            // handle error here
        }

        return this.save(from, to, messageText, DirectionEnum.OUT);
    }

    public List<Message> listMessagesByChannel(String channel) {
        return this.messageRepository.findAllByChannelOrderByCreateDateTimeAsc(channel);
    }
}
