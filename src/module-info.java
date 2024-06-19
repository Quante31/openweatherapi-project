/**
 * 
 */
/**
 * 
 */
module Weather {
	requires java.net.http;
    opens com.quante31.weatherapi.model to com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
}