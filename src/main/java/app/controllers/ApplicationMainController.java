package app.controllers;

import app.services.DownloadGifByCurrencyRateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api", produces = "image/gif")
@Tag(name = "The Main Controller", description = "Receive a .gif")
public class ApplicationMainController {

    private final DownloadGifByCurrencyRateService downloadGifByCurrencyRateService;

    @GetMapping
    public ResponseEntity<byte[]> differenceOfOneDay(@RequestParam(value = "base", defaultValue = "USD") String base) {
        return downloadGifByCurrencyRateService.receiveGifByRUBRate(base);
    }
}
