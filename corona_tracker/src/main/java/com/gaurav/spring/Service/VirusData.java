package com.gaurav.spring.Service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gaurav.spring.model.Location;

@Service
public class VirusData {

//	private static String VIRUS_DATA = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String VIRUS_DATA = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/latest/owid-covid-latest.csv";
	private List<Location> locations = new ArrayList<>();

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@PostConstruct
	@Scheduled(cron = "* 1 * * * *")
	public void fetchData() throws IOException, InterruptedException {
		List<Location> newLocations=new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader stringReader=new StringReader(httpResponse.body()); 
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(stringReader);
		for (CSVRecord record : records) {
			Location location=new Location();
			location.setLocation(record.get("location"));
			if(record.get("people_vaccinated").length()<=0) {
				location.setPeople_vaccinated(0l);
			}else {
				location.setPeople_vaccinated((long)Double.parseDouble(record.get("people_vaccinated")));
			}
			if(record.get("population").length()<=0) {
				location.setPopulation(0l);
			}else {
				location.setPopulation((long)Double.parseDouble(record.get("population")));
			}
			if(record.get("total_cases").length()<=0) {
				location.setTotal_cases(0l);
			}else {
				location.setTotal_cases((long)Double.parseDouble(record.get("total_cases")));
			}
			if(record.get("total_deaths").length()<=0) {
				location.setTotal_deaths(0l);
			}else {
				location.setTotal_deaths((long)Double.parseDouble(record.get("total_deaths")));
			}
			
			newLocations.add(location);
		}
		this.locations= newLocations;
	}
}
