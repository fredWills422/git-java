package com.maxtrain.bootcamp.prs.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	Product findByIdAndVendorId (Integer id, Integer vendorId);
}
