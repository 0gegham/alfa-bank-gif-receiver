package app.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DownloadGifByCurrencyRateServiceImplTest {

    @Autowired
    private DownloadGifByCurrencyRateServiceImpl downloadGifByCurrencyRateService;

    @Test
    void receiveGifByRUBRate() {
        ResponseEntity<byte[]> gif = downloadGifByCurrencyRateService.receiveGifByRUBRate("USD");

        assertAll(
                () -> assertTrue(gif.hasBody()),
                () -> assertEquals(HttpStatus.OK, gif.getStatusCode())
        );
    }
}