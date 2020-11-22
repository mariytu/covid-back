package cl.covid.mserv.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class GetCasesPerCountryRequestVO {

	@NotNull
	@NotEmpty
	@ApiModelProperty(notes = "Country must be the country_slug", example = "chile")
	private String slug;
	
}
