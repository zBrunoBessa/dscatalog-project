package com.brunobessa.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.brunobessa.dscatalog.entities.Product;
import com.brunobessa.dscatalog.tests.Factory;

@DataJpaTest
class ProductRepositoryTests {

	
	@Autowired
	private ProductRepository repository;
	
	private Long existingId;
	private Long nonExistingId;
	private Long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception{
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProducts = 25L;
	}

    @Test
    void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		assertNotNull(product.getId());
		assertEquals(countTotalProducts + 1, product.getId());
	}


    @Test
    void deleteShouldDeleteObjectWhenIdExists() {		
				
		repository.deleteById(existingId);
		Optional<Product> result = repository.findById(existingId);
		
		assertFalse(result.isPresent());
	}


    @Test
    void findByIdShouldReturnNonEmptyOptionalWhenIdExists() {
		
		Optional<Product> result = repository.findById(existingId);
		assertTrue(result.isPresent());
	}

    @Test
    void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExist() {
		
		Optional<Product> result = repository.findById(nonExistingId);
		assertTrue(result.isEmpty());
	}
}
