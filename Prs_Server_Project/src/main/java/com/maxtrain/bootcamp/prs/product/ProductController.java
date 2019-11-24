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
	
	private JsonResponse save(Product product) {
		try {
			return JsonResponse.getInstance(productRepo.save(product));
		}catch(IllegalArgumentException ex) {
			return JsonResponse.getInstance("Parameter product cannot be null");
		}catch(Exception ex){
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping()
	public @ResponseBody JsonResponse getAll() {
		return JsonResponse.getInstance(productRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public @ResponseBody JsonResponse getByPk(@PathVariable Integer id) {
		try {
			if(id ==null) return JsonResponse.getInstance("Parameter id cannot be null");
			Optional<Product> p = productRepo.findById(id);
			if(!p.isPresent()) {
				return JsonResponse.getInstance("Product not found");
			}return JsonResponse.getInstance(p.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PostMapping
	public @ResponseBody JsonResponse insert(@RequestBody Product product) {
		try {
			return save(product);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			if(id != product.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match");
			}
			return save(product);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			if(id==null) return JsonResponse.getInstance("Parameter id can't be null");
			Optional<Product> p = productRepo.findById(id);
			if(!p.isPresent()) {
				return JsonResponse.getInstance("Product not found");
			}
			productRepo.deleteById(p.get().getId());
			return JsonResponse.getInstance(p.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
//	@GetMapping("/authenticate")
//	public @ResponseBody JsonResponse authenticate(@RequestBody Product product) {
//		Integer id = product.getId();
//		Integer vendorId = product.getVendorId();
//		try {
//			Product p = productRepo.findByIdAndVendorId(id, vendorId);
//			if(p==null) {
//				return JsonResponse.getInstance("Product not found");
//			}return JsonResponse.getInstance(p);
//		}catch (Exception ex) {
//			return JsonResponse.getInstance(ex.getMessage());
//		}
//	}
	
}
