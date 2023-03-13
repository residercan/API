package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04() {
        //Set the URL
        //String url = "https://jsonplaceholder.typicode.com/todos";
        spec.pathParams("first", "todos");
        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.
                then().
                statusCode(200).//HTTP Status Code should be 200
                contentType("application/json").//Response format should be "application/json"
                body("id", hasSize(200),//There should be 200 todos
                    "title", hasItem("quis eius est sint explicabo"),//"quis eius est sint explicabo" should be one of the todos title
                    "userId", hasItems(2, 7, 9));//2, 7, and 9 should be among the userIds

        //hasSize ile tüm id'leri say dedik böylece kaç adet bulunduğunu öğrendik ve toplam kaç adet todos parametresi olduğunu belirledik.
        //hasItem ile tüm title'larda "--" BUNU içeriyor mu dedik
        //hasItems ile "--" BUNLARI içeriyor mu dedik. Birden fazla değer içerip içermediğini sorgulamak için kullanılır.



    }


}
