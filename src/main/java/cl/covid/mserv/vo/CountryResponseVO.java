package cl.covid.mserv.vo;

import lombok.Data;

@Data
public class CountryResponseVO {
	
	private String countryCode;
	private String country;
	private String slug;
	private Long totalConfirmed;
	private Long totalDeaths;
	private Long totalRecovered;
	
	public CountryResponseVO(String countryCode, String country, String slug, Long totalConfirmed, Long totalDeaths, Long totalRecovered) {
		this.countryCode = countryCode;
		this.country = country;
		this.slug = slug;
		this.totalConfirmed = totalConfirmed;
		this.totalDeaths = totalDeaths;
		this.totalRecovered = totalRecovered;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void seetCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public Long getTotalConfirmed() {
		return totalConfirmed;
	}
	
	public void setTotalConfirmed(Long totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	
	public Long getTotalDeaths() {
		return totalDeaths;
	}
	
	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	
	public Long getTotalRecovered() {
		return totalRecovered;
	}
	
	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	
}
