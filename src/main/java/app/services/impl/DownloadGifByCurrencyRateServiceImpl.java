package app.services.impl;

import app.services.CurrencyService;
import app.services.DownloadGifByCurrencyRateService;
import app.services.DownloadService;
import app.services.GifService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class DownloadGifByCurrencyRateServiceImpl implements DownloadGifByCurrencyRateService {

    private final GifService gifService;
    private final DownloadService downloadService;
    private final CurrencyService currencyService;
    private final String exchange;

    public DownloadGifByCurrencyRateServiceImpl(@Value("${currency.exchange}") String exchange,
                                                GifService gifService,
                                                DownloadService downloadService,
                                                CurrencyService currencyService) {
        this.gifService = gifService;
        this.downloadService = downloadService;
        this.currencyService = currencyService;
        this.exchange = exchange;
    }

    @Override
    public ResponseEntity<byte[]> receiveGifByRUBRate(String base) {
        String tag = currencyService.compareRatesByDate(base, exchange,
                LocalDate.now(), LocalDate.now().minusDays(1)) > 0 ? "rich" : "broke";
        String url = Objects.requireNonNull(gifService.randomGifByTag(tag).getBody()).getUrl();
        return downloadService.downloadByUrl(url);
    }

}
