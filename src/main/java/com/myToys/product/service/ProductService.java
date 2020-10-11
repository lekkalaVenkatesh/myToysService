package com.myToys.product.service;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myToys.product.constants.MessageConstants;
import com.myToys.product.dto.ProductDto;
import com.myToys.product.exception.FileProcessingException;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(ProductService.class);

	private final CSVReaderService cSVReaderService;

	public ProductService(CSVReaderService cSVReaderService) {
		this.cSVReaderService = cSVReaderService;
	}
	
	public boolean getBoolean1() {
    	return true;
     }
	
    public boolean getBoolean() {
    	return cSVReaderService.getBoolean();
     }

	public List<ProductDto> getProducts() {
		try {

			return cSVReaderService.processCSVFile();
		} catch (NoSuchFileException noSuchFileException) {
			logger.error(MessageConstants.PRODUCT_FILE_NOT_FOUND, noSuchFileException.getMessage());
			throw new FileProcessingException(MessageConstants.PRODUCT_FILE_NOT_FOUND);
		} catch (IOException exception) {
			logger.error(MessageConstants.PRODUCT_FILE_PARSING_ERROR, exception.getMessage());
			throw new FileProcessingException(MessageConstants.PRODUCT_FILE_PARSING_ERROR);
		}

	}

}
