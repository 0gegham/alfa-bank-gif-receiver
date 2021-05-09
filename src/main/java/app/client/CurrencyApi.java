package app.client;

import app.models.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "currency-api", url = "${currency.url}")
public interface CurrencyApi {
    @GetMapping("/historical/{date}.json?app_id=${currency.api_id}")
    ResponseEntity<Currency> getCurrency(@PathVariable(value = "date") String date,
                                        @RequestParam(value = "base", defaultValue = "USD") String base);
    @GetMapping("/currencies.json")
    ResponseEntity<Map<String, String>> currencies();
}
