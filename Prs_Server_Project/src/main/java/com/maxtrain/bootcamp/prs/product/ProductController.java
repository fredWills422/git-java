package com.maxtrain.bootcamp.prs.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maxtrain.bootcamp.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping()
	public @ResponseBody JsonResponse getAll() {
		return JsonResponse.getInstance(productRepo.findAll());
	}
	@GetMapping("/{id}")
	public @ResponseBody JsonResponse getByPk(@PathVariable Integer id) {
		try {
			Optional<Product> p = productRepo.findById(id);
			if(!p.isPresent()) {
				return JsonResponse.getInstance("Product not found");
			}return JsonResponse.getInstance(p.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	private JsonResponse save(Product product) {
		try {
			Product p = productRepo.save(product);
			return JsonResponse.getInstance(p);
		}catch(Exception ex){
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	@PostMapping
	public @ResponseBody JsonResponse insert(@RequestBody Product product) {
		return save(product);
	}
	@PutMapping("{/id}")
	public @ResponseBody JsonResponse update(@RequestBody Product product, @PathVariable Integer id) {
		return save(product);
	}
	@DeleteMapping("{/id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			Optional<Product> p = productRepo.findById(id);
			if(!p.isPresent()) {
				return JsonResponse.getInstance("Product not found");
			}
			productRepo.deleteById(id);
			return JsonResponse.getInstance(p.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	@GetMapping("/authenticate")
	public @ResponseBody JsonResponse authenticate(@RequestBody Product product) {
		Integer id = product.getId();
		Integer vendorId = product.getVendorId();
		try {
			Product p = productRepo.findByIdAndVendorId(id, vendorId);
			if(p==null) {
				return JsonResponse.getInstance("Product not found");
			}return JsonResponse.getInstance(p);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
}
