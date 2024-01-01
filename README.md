# WeatherReporter

This application provide REST API end point to get weather report of a city in world

URL: http://<HostName>:<Port>/weatherReporter/wetherNow/{city}
The Result is JSON format as given below .
Eg:{
    "placeName": "Berlin",
    "country": "Germany",
    "temperature_c": 14,
    "condition": "Sunny",
    "wind_kmph": 15.1,
    "humidity": 77
 }
 
 Implemantation: The weatherReporter consume another API called as "APIXU".It provide a complex JSON output of all detailed of weather information 
    and weatherReporter read tat JSON and take necessary information and provide a simple JSON to the customers.
 Technology Stack:
                Java7
                Spring Boot
                REST webservice
                JMockit for Unit Testing
                Maven
  How To Start: Inside the Project ,run this command from Command prompt: mvn spring-boot:run
  
  TODO: API Security
  Now we implemented an ApiKey as header name and header value as 12345. Will change this method and an indpendent Identity Service will
  add in the next relase.
  test change
