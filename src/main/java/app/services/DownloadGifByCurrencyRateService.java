package app.services;

import org.springframework.http.ResponseEntity;

public interface DownloadGifByCurrencyRateService {
    ResponseEntity<byte[]> receiveGifByRUBRate(String base);
}
