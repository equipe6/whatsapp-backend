package br.edu.unisinos.whatsapp.controllers;

import br.edu.unisinos.whatsapp.services.MessageService;
import br.edu.unisinos.whatsapp.services.WebhookMessageService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void testxxxxxx() throws Exception {

    }

}