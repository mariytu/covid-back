package cl.covid.mserv.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.covid.mserv.services.CovidService;
import cl.covid.mserv.vo.CountryResponseVO;
import cl.covid.mserv.vo.GetCasesPerCountryResponseVO;
import cl.covid.mserv.vo.GetSummaryResponseVO;
import cl.covid.mserv.vo.HistoryResponseVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/v1/covid")
public class CovidController {
	
	@Autowired
	CovidService covidService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/summary")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	public ResponseEntity<List<CountryResponseVO>> getSummary() {
		
		try {
			GetSummaryResponseVO resp = covidService.getSummary().getBody();
			
			ArrayList<CountryResponseVO> countries = new ArrayList<CountryResponseVO>();
			resp.getCountries().forEach(countrySummary -> countries.add(new CountryResponseVO(
					countrySummary.getCountryCode(),
					countrySummary.getCountry(),
					countrySummary.getSlug(),
					countrySummary.getTotalConfirmed(),
					countrySummary.getTotalDeaths(),
					countrySummary.getTotalRecovered()
				)));
			
			return ResponseEntity.ok(countries);
		} catch (Exception ex) {
			System.out.println(ex);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/country/{slug}")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST}) 
	public ResponseEntity<List<HistoryResponseVO>> getCasesPerCountry(@PathVariable("slug") String slug) {
		
		try {
			List<GetCasesPerCountryResponseVO> resp = covidService.getCasesPerCountry(slug).getBody();
			
			ArrayList<HistoryResponseVO> history = new ArrayList<HistoryResponseVO>();
			resp.forEach(infoDay -> history.add(new HistoryResponseVO(
					infoDay.getCountry(),
					infoDay.getActive(),
					infoDay.getConfirmed(),
					infoDay.getDeaths(),
					infoDay.getRecovered(),
					infoDay.getDate()
				)));
			
			Collections.sort(history);
			
			return ResponseEntity.ok(history);
		} catch (Exception ex) {
			System.out.println(ex);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
