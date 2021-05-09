package app.services;

import java.time.LocalDate;

public interface CurrencyService {
    double getCurrencyRateByDate(String base, String exchange, LocalDate date);
    int compareRatesByDate(String base, String exchange, LocalDate firstDate, LocalDate secondDate);
}
