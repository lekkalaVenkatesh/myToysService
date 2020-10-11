package com.myToys.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myToys.product.constants.MessageConstants;
import com.myToys.product.exception.FileProcessingException;
import com.myToys.product.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void getProductData_valid() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/product")).andExpect(status().isOk());

	}

	@Test
	public void getProductData_internalServerError() throws Exception {

		when(productService.getProducts())
				.thenThrow(new FileProcessingException(MessageConstants.PRODUCT_FILE_NOT_FOUND));

		mockMvc.perform(MockMvcRequestBuilders.get("/product")).andExpect(status().isInternalServerError());

	}
}
