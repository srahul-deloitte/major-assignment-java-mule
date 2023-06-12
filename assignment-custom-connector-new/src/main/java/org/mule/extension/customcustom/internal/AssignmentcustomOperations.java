package org.mule.extension.customcustom.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class AssignmentcustomOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config AssignmentcustomConfiguration configuration, @Connection AssignmentcustomConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }

  /**
   * Private Methods are not exposed as operations
   */
  @MediaType(value = ANY, strict = false)
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
 } 
  @MediaType(value = ANY, strict = false)
  public boolean validateEmail(String email)
  {
	  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
              "[a-zA-Z0-9_+&*-]+)*@" +
              "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
              "A-Z]{2,7}$";
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(email);
	  return matcher.matches(); 
	  }
  @MediaType(value = ANY, strict = false)
  public String emailValidator(String email) 
  {
	  boolean isValid = validateEmail(email);
	  return Boolean.toString(isValid);
	  } 
}
