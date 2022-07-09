package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.services.MessageService;
import br.edu.unisinos.whatsapp.services.WebhookMessageService;
import com.zenvia.api.sdk.client.ChannelType;
import com.zenvia.api.sdk.messages.Message;
import com.zenvia.api.sdk.messages.MessageDirection;
import com.zenvia.api.sdk.webhook.MessageEvent;
import com.zenvia.api.sdk.webhook.MessageStatus;
import com.zenvia.api.sdk.webhook.MessageStatusEvent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class WebhookControllerTest {

    @Mock
    private WebhookMessageService webhookMessageService;

    @Mock
    private MessageService messageService;

    private WebhookController webhookController;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.webhookController = BDDMockito.spy(new WebhookController(webhookMessageService, messageService));
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testPostWebhookMessage() throws Exception {
        String id = "234567890";
        ZonedDateTime timestamp = ZonedDateTime.now();
        String subscriptionId = "9876543";
        ChannelType channel = ChannelType.whatsapp;
        MessageDirection direction = MessageDirection.IN;
        Message message = new Message(null, null, null, null, null, null);

        MessageEvent messageEvent = new MessageEvent(id, timestamp, subscriptionId, channel, direction, message);

        var result = this.webhookController.message(messageEvent);
        assertNotNull(result);
    }

    @Test
    void testPostWebhookStatus() throws Exception {
        String id = "234567890";
        ZonedDateTime timestamp = ZonedDateTime.now();
        String subscriptionId = "9876543";
        ChannelType channel = ChannelType.whatsapp;
        String messageId = "345678";
        Integer contentIndex = 1;
        MessageStatus messageStatus = new MessageStatus(null, null, null, null);

        MessageStatusEvent messageStatusEvent = new MessageStatusEvent(id, timestamp, subscriptionId, channel, messageId, contentIndex, messageStatus);

        var result = this.webhookController.status(messageStatusEvent);
        assertNotNull(result);

    }

}