package com.myToys.product.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.myToys.product.dto.ProductDto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

	@Autowired
	public CSVReaderService cSVReaderService;

	private ProductService productService;

	@BeforeEach
	public void setup() {

		productService = new ProductService(cSVReaderService);
	}

	@Test
	public void getProducts_ReturnListProducts() throws IOException {

		List<ProductDto> list = productService.getProducts();

		assertNotNull(list);

	}

}
