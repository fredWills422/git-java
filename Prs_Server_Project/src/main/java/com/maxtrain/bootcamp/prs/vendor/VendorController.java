package com.maxtrain.bootcamp.prs.vendor;

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
@RequestMapping(path="/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping()
	public @ResponseBody JsonResponse getAll() {
		return JsonResponse.getInstance(vendorRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public @ResponseBody JsonResponse getByPK(@PathVariable Integer id) {
		try {
			Optional<Vendor> v= vendorRepo.findById(id);
			if(!v.isPresent()) {
				return JsonResponse.getInstance("Vendor not found");
			}
			return JsonResponse.getInstance(v.get());
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	private JsonResponse save (Vendor vendor) {
		try {
			Vendor v = vendorRepo.save(vendor);
			return JsonResponse.getInstance(v);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	@PostMapping()
	public @ResponseBody JsonResponse insert(@RequestBody Vendor vendor) {
		return save(vendor);
	}
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse update(@RequestBody Vendor vendor, @PathVariable Integer id) {
		return save(vendor);
	}
	@DeleteMapping("/{id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			Optional<Vendor> v = vendorRepo.findById(id);
			if(!v.isPresent()) {
				return JsonResponse.getInstance("Vendor not found");
			}
			vendorRepo.deleteById(id);
			return JsonResponse.getInstance(v.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
		
	}
	@GetMapping("/authenticate")
	public @ResponseBody JsonResponse authenticate (@RequestBody Vendor vendor) {
		Integer id = vendor.getId();
		String code = vendor.getCode();
		try {
			Vendor v = vendorRepo.findByIdAndCode(id, code);
			if(v==null) {
				return JsonResponse.getInstance("Vendor not found");
			}
			return JsonResponse.getInstance(v);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
}
