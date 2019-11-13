package com.maxtrain.bootcamp.prs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
