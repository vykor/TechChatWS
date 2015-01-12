package TechChatWS;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

public abstract class AbstractRestHandler {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) {
    	log.info("Uncaught exception : " + ex.toString());
    	
        response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return new String("Error occurred: " + ex.toString());
    }
	
    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody String handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request, HttpServletResponse response) {
    	log.info("IllegalArgumentException : " + ex.toString());
    	
        response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new String("Error occurred: " + ex.toString());
    }
	
}