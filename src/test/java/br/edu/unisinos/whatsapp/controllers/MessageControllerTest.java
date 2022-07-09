package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.dtos.MessageSendDto;
import br.edu.unisinos.whatsapp.services.MessageService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @Mock
    private MessageService messageService;

    private MessageController messageController;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.messageController = BDDMockito.spy(new MessageController(messageService));
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testSend() throws Exception {
        MessageSendDto messageSendDto = new MessageSendDto("Ola Mundo.");
        String phoneNumber = "5551999997788";

        var result = this.messageController.send(messageSendDto, phoneNumber);
        assertNotNull(result);
    }

    @Test
    void testListMessagesByChannel() throws Exception {
        String channel = "deluxe-ankle-5551999997788";
        var result = this.messageController.listMessagesByChannel(channel);
        assertNotNull(result);
    }

    @Test
    void testListAllChannel() throws Exception {
        var result = this.messageController.listAllChannel();
        assertNotNull(result);
    }
}