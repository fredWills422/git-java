package com.maxtrain.bootcamp.prs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maxtrain.bootcamp.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping(path="/requests")
public class RequestController {

	@Autowired
	private RequestRepository requestRepo;
	
	@GetMapping()
	public @ResponseBody JsonResponse getAll() {
		
		Iterable<Request> requests = requestRepo.findAll();
		return JsonResponse.getInstance(requests);
	}
}
