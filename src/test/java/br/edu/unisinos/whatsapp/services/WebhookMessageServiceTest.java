package br.edu.unisinos.whatsapp.services;

import br.edu.unisinos.whatsapp.repositories.WebhookMessageRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WebhookMessageServiceTest {

    @Mock
    private WebhookMessageRepository webhookMessageRepository;

    private WebhookMessageService webhookMessageService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.webhookMessageService = BDDMockito.spy(new WebhookMessageService(webhookMessageRepository));
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