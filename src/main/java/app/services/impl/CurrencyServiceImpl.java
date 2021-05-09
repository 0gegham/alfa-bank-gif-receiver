package app.services.impl;

import app.client.CurrencyApi;
import app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyApi currencyApi;

    @Override
    public double getCurrencyRateByDate(String base, String exchange, LocalDate date) {
        return Objects.requireNonNull(currencyApi
                .getCurrency(date.toString(), base).getBody())
                .getRates().get(exchange);
    }

    @Override
    public int compareRatesByDate(String base, String exchange,
                                  LocalDate firstDate, LocalDate secondDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -24);

        return Double.compare(
                getCurrencyRateByDate(base, exchange, firstDate),
                getCurrencyRateByDate(base, exchange, secondDate)
        );
    }
}
