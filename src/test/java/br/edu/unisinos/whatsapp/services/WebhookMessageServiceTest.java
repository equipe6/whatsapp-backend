package br.edu.unisinos.whatsapp.services;

import br.edu.unisinos.whatsapp.entities.WebhookMessage;
import br.edu.unisinos.whatsapp.repositories.WebhookMessageRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;

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
    void testSave() throws Exception {
        given(this.webhookMessageRepository.save(any(WebhookMessage.class))).willReturn(new WebhookMessage());

        var result = this.webhookMessageService.save("Ola fulano.");
        assertNotNull(result);
    }


}