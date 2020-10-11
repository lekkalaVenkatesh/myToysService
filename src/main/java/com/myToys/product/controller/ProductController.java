package com.myToys.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myToys.product.dto.ProductDto;
import com.myToys.product.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	private final ProductService productService;

	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping()
	public List<ProductDto> getProductData() {
		return productService.getProducts();
	}

}
