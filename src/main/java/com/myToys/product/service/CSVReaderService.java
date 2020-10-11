package com.myToys.product.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myToys.product.dto.ProductDto;

@Service
public class CSVReaderService {

	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	public boolean getBoolean() {
		return true;
	}

	public List<ProductDto> processCSVFile() throws IOException {

		CSVParser csvParser = getCSVParser();
		return processCSVRecords(csvParser);
	}

	List<ProductDto> processCSVRecords(CSVParser csvParser) throws IOException {
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (CSVRecord csvRecord : csvParser) {
			ProductDto productDto = new ProductDto();

			// Headers name can be externalize if we know that header names will be
			// customizable

			productDto.setId(csvRecord.get("ID") != null ? Long.parseLong(csvRecord.get("ID")) : null);
			productDto.setName(csvRecord.get("NAME"));
			productDto.setPrice(csvRecord.get("PRICE") != null ? Double.parseDouble(csvRecord.get("PRICE")) : null);
			productDto.setOldPrice(csvRecord.get("OLD_PRICE") != null ? Double.parseDouble(csvRecord.get("OLD_PRICE")) : null);
			productDto.setStock(csvRecord.get("STOCK") != null ? Long.parseLong(csvRecord.get("STOCK")) : null);
			productDto.setBrand(csvRecord.get("BRAND"));
			productDtos.add(productDto);
		}
		return productDtos;

	}

	CSVParser getCSVParser() throws IOException {

		// This can be externalize using the file location from application.properties
		Path path = Paths.get("src/main/resources", "product_data.csv");

		Reader reader = Files.newBufferedReader(path);
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
		return csvParser;
	}

}
