package cl.covid.mserv.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import cl.covid.mserv.exception.ResponseErrorHandlerImpl;
import cl.covid.mserv.interceptor.RequestResponseRestTemplateLogInterceptor;
import cl.covid.mserv.vo.GetCasesPerCountryResponseVO;
import cl.covid.mserv.vo.GetSummaryResponseVO;
import cl.covid.mserv.vo.GetCasesPerCountryRequestVO;

@Service
public class CovidService {
	
	@Value("${covid.base.url}")
	private String covidBaseUrl;
	@Value("${covid.read.timeout}")
	private Integer covidUrlReadTimeout;
	@Value("${covid.connect.timeout}")
	private Integer covidUrlConnectTimeout;
	
	public ResponseEntity<GetSummaryResponseVO> getSummary() throws Exception {
				
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory ();
	    factory.setReadTimeout(covidUrlReadTimeout);
	    factory.setConnectTimeout(covidUrlConnectTimeout);
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
	    restTemplate.setInterceptors(Collections.singletonList(new RequestResponseRestTemplateLogInterceptor()));
	    restTemplate.setErrorHandler(new ResponseErrorHandlerImpl());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> request = new HttpEntity<>(headers);
		Map<String, String> params = new HashMap<String, String>();
		UriComponents builder = UriComponentsBuilder.fromUriString(covidBaseUrl+"/summary").buildAndExpand(params);
		ParameterizedTypeReference<GetSummaryResponseVO
		>  parameterizedTypeReference = new ParameterizedTypeReference<GetSummaryResponseVO>(){};
		
		ResponseEntity<GetSummaryResponseVO> resultado = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request,parameterizedTypeReference);

		return resultado; 
	}
	
	public ResponseEntity<List<GetCasesPerCountryResponseVO>> getCasesPerCountry(String slug) throws Exception {
		
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory ();
	    factory.setReadTimeout(covidUrlReadTimeout);
	    factory.setConnectTimeout(covidUrlConnectTimeout);
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
	    restTemplate.setInterceptors(Collections.singletonList(new RequestResponseRestTemplateLogInterceptor()));
	    restTemplate.setErrorHandler(new ResponseErrorHandlerImpl());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<GetCasesPerCountryRequestVO> request = new HttpEntity<>(headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("slug", slug);
		UriComponents builder = UriComponentsBuilder.fromUriString(covidBaseUrl+"/country/{slug}").buildAndExpand(params);
		ParameterizedTypeReference<List<GetCasesPerCountryResponseVO>>  parameterizedTypeReference = new ParameterizedTypeReference<List<GetCasesPerCountryResponseVO>>(){};
		ResponseEntity<List<GetCasesPerCountryResponseVO>> resultado = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request, parameterizedTypeReference);

		return resultado; 
	}
	
}