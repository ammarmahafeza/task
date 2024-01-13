package apitest.endpoints;
//All the needed Services
public class Routes {
public static String baseurl ="https://www.almosafer.com/api";

public static String searchPost =baseurl+"/enigma/search/async";
public static String  flightApiURL= baseurl +"/v3/flights/flight/search?query={destinationId}-{originId}/{fromdate}/{todate}/Economy/{adultscount}Adult";
	
}
 
