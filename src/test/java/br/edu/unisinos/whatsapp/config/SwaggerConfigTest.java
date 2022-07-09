package br.edu.unisinos.whatsapp.config;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.swaggerConfig = BDDMockito.spy(new SwaggerConfig());
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testCustomOpenAPI() throws Exception {
        this.swaggerConfig.customOpenAPI("teste", "1.0.1");
    }

}