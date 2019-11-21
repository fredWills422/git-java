package com.maxtrain.bootcamp.prs.request;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maxtrain.bootcamp.prs.util.JsonResponse;
//import com.maxtrain.bootcamp.prs.vendor.Vendor;

@CrossOrigin
@RestController
@RequestMapping(path="/requests")
public class RequestController {

	private static final String REQUEST_STATUS_NEW = "NEW";
	private static final String REQUEST_STATUS_EDIT = "EDIT";
	private static final String REQUEST_STATUS_REVIEW = "REVIEW";
	private static final String REQUEST_STATUS_APPROVE = "APPROVED";
	private static final String REQUEST_STATUS_REJECT= "REJECTED";
	
	
	@Autowired
	private RequestRepository requestRepo;
	
	private JsonResponse save (Request request) {
		try {
			Request r = requestRepo.save(request);
			return JsonResponse.getInstance(r);
		}catch(IllegalArgumentException ex) {
			return JsonResponse.getInstance("Parameter request can't be null");
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping()
	public JsonResponse getAll() {
		
		return JsonResponse.getInstance(requestRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public JsonResponse getByPK(@PathVariable Integer id) {
		try {
			Optional<Request> r= requestRepo.findById(id);
			if(!r.isPresent()) {
				return JsonResponse.getInstance("Vendor not found");
			}
			return JsonResponse.getInstance(r.get());
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PostMapping()
	public JsonResponse insert(@RequestBody Request request) {
		try {
			return save(request);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/{id}")
	public JsonResponse update(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id!=request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request");
			}
			return save(request);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	@DeleteMapping("/{id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			Optional<Request> r = requestRepo.findById(id);
			if(!r.isPresent()) {
				return JsonResponse.getInstance("Request not found");
			}
			requestRepo.deleteById(id);
			return JsonResponse.getInstance(r.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
		
	}
	
	private JsonResponse setRequestStatus(Request request, String status) {
		try {
			request.setStatus(status);
			return save(request);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@GetMapping("/reviews/{userId}")
	public JsonResponse getRequestWithStatusOfReview(@PathVariable Integer userId) {
		try {
			if(userId==null) {
				return JsonResponse.getInstance("UserId parameter can't be null");
			}
			Iterable<Request> requests
				= requestRepo.getRequestByStatusAndUserIdNot(REQUEST_STATUS_REVIEW, userId);
			return JsonResponse.getInstance(requests);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/review/{id}")
	public JsonResponse reveiw(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id!= request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request.id");
			}
			request.setSubmittedDate(new Date(System.currentTimeMillis()));
			if(request.getTotal() <= 50) {
				return setRequestStatus(request, REQUEST_STATUS_APPROVE);
			}
			return setRequestStatus(request, REQUEST_STATUS_REVIEW);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/approve/{id}")
	public JsonResponse approve(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id != request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request.id");
			}return setRequestStatus(request, REQUEST_STATUS_APPROVE);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/reject/{id}")
	public JsonResponse reject(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id != request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request.id");
			}return setRequestStatus(request, REQUEST_STATUS_REJECT);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/new/{id}")
	public JsonResponse newStatus(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id != request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request.id");
			}return setRequestStatus(request, REQUEST_STATUS_NEW);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/edit/{id}")
	public JsonResponse editStatus(@RequestBody Request request, @PathVariable Integer id) {
		try {
			if(id != request.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match request.id");
			}return setRequestStatus(request, REQUEST_STATUS_EDIT);
		}catch (Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
}
