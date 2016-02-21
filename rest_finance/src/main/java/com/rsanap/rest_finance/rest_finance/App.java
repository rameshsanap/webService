package com.rsanap.rest_finance.rest_finance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			// singleStock();
			historicalStok();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void singleStock() throws IOException {
		Stock stock = YahooFinance.get("INTC");

		BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

		System.out.println("Intel Corp ");
		System.out.println("Price " + price);
		System.out.println("Change " + change);
		// System.out.println("Peg "+peg);
		// peg
		// stock.print();
	}

	private static void historicalStok() throws IOException {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -1); // from 1 year ago

		Stock google = YahooFinance.get("GOOG");
		List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to,
				Interval.DAILY);
		for (int i = 0; i < googleHistQuotes.size(); i++) {
			System.out.println(googleHistQuotes.get(i).getClose());
		}
	}
}
