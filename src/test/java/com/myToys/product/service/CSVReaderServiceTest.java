package com.myToys.product.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CSVReaderServiceTest {

	private static CSVReaderService cSVReaderService;

	private static List<String> headerNames;

	@BeforeAll
	static void initialize() {
		cSVReaderService = new CSVReaderService();
		headerNames = getHeaderNames();

	}

	@Test
	public void readsHeader() throws IOException {

		CSVParser cSVParser = cSVReaderService.getCSVParser();

		List<String> headers = cSVParser.getHeaderNames();

		assertTrue(headers.size() == 6);

		assertTrue(headerNames.containsAll(headers));

	}

	static List<String> getHeaderNames() {

		List<String> headers = new ArrayList<String>();

		headers.add("ID");
		headers.add("NAME");
		headers.add("PRICE");
		headers.add("OLD_PRICE");
		headers.add("STOCK");
		headers.add("BRAND");

		return headers;
	}
}
