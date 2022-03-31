package com.gaurav.spring.Controllers;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gaurav.spring.Service.VirusData;
import com.gaurav.spring.model.Location;

@Controller
public class MainController {

	@Autowired
	VirusData virusData;
	@GetMapping("/")
	public String homePage(Model model) {
		List<Location> allLocation=virusData.getLocations();
//		double totalreportedCases=0.0;
//		for(Location locations:allLocation) {
//			totalreportedCases+=locations.getTotal_cases();
//		}
//		double totaldeaths=0.0;
//		for(Location locations:allLocation) {
//			totaldeaths+=locations.getTotal_deaths();
//		}
//		double totalpopulation=0.0;
//		for(Location locations:allLocation) {
//			totalpopulation+=locations.getPopulation();
//		}
//		
//		
//		long totalReportedCases=(long)totalreportedCases;
//		long totalDeaths=(long)totaldeaths;
//		long totalPopulation=(long)totalpopulation;
//		
		model.addAttribute("LocationStates",allLocation);
		model.addAttribute("totalCountry",allLocation.size());
//		model.addAttribute("totalDeaths",totalDeaths);
//		model.addAttribute("totalPopulation",totalPopulation);
		return "main";
	}
}
