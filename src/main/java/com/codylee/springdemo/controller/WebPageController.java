package com.codylee.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codylee.springdemo.service.GenericWebPageService;

// This controller essentially acts as a "main" function to get the MySQL data
// and put it on the screen for the user.
@Controller
public class WebPageController {
	
	// Grab a reference to our generic web page service
	// so that we can use its functions to grab data.
	@Autowired
	private GenericWebPageService showSwDataService;
	
	@RequestMapping
	public String doSwDataDump(Model model) {
		
		// 1. retrieving the processed data
		List<String> starWarsData = showSwDataService.getSwData();
		
		// 2. add data to the model
		model.addAttribute("starWarsData", starWarsData);
		
		// 3. return the logical view name
		return "swMovieView"; 
	}
	
}
