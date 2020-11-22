package cl.covid.mserv.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class GetCasesPerCountryResponseVO {
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("CountryCode")
	private String countryCode;
	
	@JsonProperty("Province")
	private String province;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("CityCode")
	private String cityCode;
	
	@JsonProperty("Lat")
	private Double lat;
	
	@JsonProperty("Lon")
	private Double lon;
	
	@JsonProperty("Confirmed")
	private Long confirmed;
	
	@JsonProperty("Deaths")
	private Long deaths;
	
	@JsonProperty("Recovered")
	private Long recovered;
	
	@JsonProperty("Active")
	private Long active;
	
	@JsonProperty("Date")
	private Date date;
	
	public String getCountry() {
		return country;
	}
	
	public Long getActive() {
		return active;
	}
	
	public Long getConfirmed() {
		return confirmed;
	}
	
	public Long getDeaths() {
		return deaths;
	}
	
	public Long getRecovered() {
		return recovered;
	}
	
	public Date getDate() {
		return date;
	}
}
