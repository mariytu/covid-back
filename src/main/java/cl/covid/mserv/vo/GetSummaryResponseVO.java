package cl.covid.mserv.vo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GetSummaryResponseVO {
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Global")
	private Global global;
	
	@JsonProperty("Countries")
	private List<CountryInfo> countries;
	
	@JsonProperty("Date")
	private Date date;
	
	public List<CountryInfo> getCountries() {
		return countries;
	}
	
	@Data
	public static class Global {
		@JsonProperty("NewConfirmed")
		private Long newConfirmed;
		
		@JsonProperty("TotalConfirmed")
		private Long totalConfirmed;
		
		@JsonProperty("NewDeaths")
		private Long newDeaths;
		
		@JsonProperty("TotalDeaths")
		private Long totalDeaths;
		
		@JsonProperty("NewRecovered")
		private Long newRecovered;
		
		@JsonProperty("TotalRecovered")
		private Long totalRecovered;
	}
	
	@Data
	public static class CountryInfo {
		@JsonProperty("Country")
		private String country;
		
		@JsonProperty("CountryCode")
		private String countryCode;
		
		@JsonProperty("Slug")
		private String slug;
		
		@JsonProperty("NewConfirmed")
		private Long newConfirmed;
		
		@JsonProperty("TotalConfirmed")
		private Long totalConfirmed;
		
		@JsonProperty("NewDeaths")
        private Long newDeaths;
		
		@JsonProperty("TotalDeaths")
        private Long totalDeaths;
		
		@JsonProperty("NewRecovered")
        private Long newRecovered;
		
		@JsonProperty("TotalRecovered")
        private Long totalRecovered;
		
		@JsonProperty("Date")
        private Date date;
		
		@JsonProperty("Premium")
        private Premium premium;
		
		public String getCountry() {
			return country;
		}
		
		public String getCountryCode() {
			return countryCode;
		}
		
		public String getSlug() {
			return slug;
		}
		
		public Long getTotalConfirmed() {
			return totalConfirmed;
		}
		
		public Long getTotalDeaths() {
			return totalDeaths;
		}
		
		public Long getTotalRecovered() {
			return totalRecovered;
		}
	}
	
	public static class Premium {}
}
