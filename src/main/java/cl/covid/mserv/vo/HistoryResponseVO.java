package cl.covid.mserv.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class HistoryResponseVO implements Comparable {
	
	private String country;
	private Long active;
	private Long confirmed;
	private Long deaths;
	private Long recovered;
	private Date date;
	
	public HistoryResponseVO(String country, Long active, Long confirmed, Long deaths, Long recovered, Date date) {
		this.country = country;
		this.active = active;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.date = date;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Long getActive() {
		return active;
	}
	
	public void setActive(Long active) {
		this.active = active;
	}
	
	public Long getConfirmed() {
		return confirmed;
	}
	
	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}
	
	public Long getDeaths() {
		return deaths;
	}
	
	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}
	
	public Long getRecovered() {
		return recovered;
	}
	
	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Object o) {
		
		return this.date.compareTo(((HistoryResponseVO)o).getDate());
	}
	
}
