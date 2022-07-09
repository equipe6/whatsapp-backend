package br.edu.unisinos.whatsapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

//@SpringBootTest
//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class WhatsappBackendApplicationTests {

    @Test
    void contextLoads() {
        WhatsappBackendApplication.showAppVersionInfo();
    }

}
