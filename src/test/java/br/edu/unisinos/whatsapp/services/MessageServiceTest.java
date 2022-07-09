package br.edu.unisinos.whatsapp.services;

import br.edu.unisinos.whatsapp.entities.Message;
import br.edu.unisinos.whatsapp.enums.DirectionEnum;
import br.edu.unisinos.whatsapp.repositories.MessageRepository;
import com.zenvia.api.sdk.client.ChannelType;
import com.zenvia.api.sdk.contents.Content;
import com.zenvia.api.sdk.contents.TextContent;
import com.zenvia.api.sdk.messages.MessageDirection;
import com.zenvia.api.sdk.webhook.MessageEvent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    private MessageService messageService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.messageService = BDDMockito.spy(new MessageService(messageRepository));
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testSave() throws Exception {
        String from = "deluxe-ankle";
        String to = "5551999998888";
        String messageText = "teste xpto";
        DirectionEnum direction = DirectionEnum.OUT;

        given(this.messageRepository.save(any(Message.class))).willReturn(new Message());

        var result = this.messageService.save(from, to, messageText, direction);
        assertNotNull(result);
    }

    @Test
    void testSaveMessageEvent() throws Exception {
        String id = "234567890";
        ZonedDateTime timestamp = ZonedDateTime.now();
        String subscriptionId = "9876543";
        ChannelType channel = ChannelType.whatsapp;
        MessageDirection direction = MessageDirection.OUT;

        String from = "deluxe-ankle";
        String to = "5551999998888";
        List<Content> contents = new ArrayList<>();
        contents.add(new TextContent("Ola fulano"));
        com.zenvia.api.sdk.messages.Message message = new com.zenvia.api.sdk.messages.Message(id, from, to, direction, channel, contents);

        DirectionEnum directionEnum = DirectionEnum.OUT;

        MessageEvent messageEvent = new MessageEvent(id, timestamp, subscriptionId, channel, direction, message);


        given(this.messageRepository.save(any(Message.class))).willReturn(new Message());

        var result = this.messageService.save(messageEvent, directionEnum);
        assertNotNull(result);
    }

    @Test
    void testSendWhatsappMessage() throws Exception {
        String from = "deluxe-ankle";
        String to = "5551999998888";
        String messageText = "teste xpto";

        given(this.messageRepository.save(any(Message.class))).willReturn(new Message());

        var result = this.messageService.sendWhatsappMessage(from, to, messageText);
        assertNotNull(result);
    }


    @Test
    void testListMessagesByChannel() throws Exception {
        given(this.messageRepository.findAllByChannelOrderByCreateDateTimeAsc(anyString())).willReturn(new ArrayList<>());

        var result = this.messageService.listMessagesByChannel("xxxxxxxxx");
        assertNotNull(result);
    }

    @Test
    void testListAllChannel() throws Exception {
        given(this.messageRepository.findDistinctChannel()).willReturn(new ArrayList<>());

        var result = this.messageService.listAllChannel();
        assertNotNull(result);
    }

}
