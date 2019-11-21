package com.maxtrain.bootcamp.prs.lineitem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxtrain.bootcamp.prs.util.JsonResponse;

@CrossOrigin
@RestController
@RequestMapping("/lineItems")
public class LineItemController {

	@Autowired
	private LineItemRepository lineItemRepo;
	
	public JsonResponse save(@RequestBody LineItem lineItem) {
		try {
			LineItem l = lineItemRepo.save(lineItem);
			return JsonResponse.getInstance(l);
		}catch(IllegalArgumentException ex) {
			return JsonResponse.getInstance("Parameter can't be null");
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping("/")
	public JsonResponse getAll() {
		try {
			return JsonResponse.getInstance(lineItemRepo.findAll());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public JsonResponse getByPK(@PathVariable Integer id) {
		try {
			Optional<LineItem> l = lineItemRepo.findById(id);
			if(!l.isPresent()) {
				return JsonResponse.getInstance("LineItem not found");
			}return JsonResponse.getInstance(l.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PostMapping()
	public JsonResponse insert(@RequestBody LineItem lineItem) {
		try {
			return save(lineItem);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public JsonResponse update(@RequestBody LineItem lineItem, @PathVariable Integer id) {
		try {
			if(id!=lineItem.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match lineItem");
			}return save(lineItem);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public JsonResponse delete(@PathVariable Integer id) {
		try {
			Optional<LineItem> l = lineItemRepo.findById(id);
			if(!l.isPresent()) {
				return JsonResponse.getInstance("LineItem not found");
			}lineItemRepo.deleteById(id);
			return JsonResponse.getInstance(l.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
}
