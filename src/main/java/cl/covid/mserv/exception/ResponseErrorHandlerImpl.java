package cl.covid.mserv.exception;

import java.io.IOException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

//@Slf4j
public class ResponseErrorHandlerImpl implements ResponseErrorHandler {
	
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException{
    	
    	if(200 != response.getRawStatusCode() && 201 != response.getRawStatusCode()) {
    		return true;
    	}
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
    	
    	throw new RuntimeException (response.getRawStatusCode() + " - " + response.getStatusCode().getReasonPhrase());
    }

}
