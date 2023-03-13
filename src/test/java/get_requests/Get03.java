package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get03 {

    /*
    Given
    https://jsonplaceholder.typicode.com/todos/23
    When
    User send GET Request to the URL
            Then
    HTTP Status Code should be 200
    And
    Response format should be “application/json”
    And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
    And
		    “completed” is false
    And
		    “userId” is 2
    */

    @Test
    public void get03(){
        //Set the URL
        String url ="https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response

        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        //1. Yol - Hard assertion
        response.//equalTo methodu ile body içerisinde bulunan değerler için assertion yapıyoruz
                then().//metadata bulunan değerler için ise statusCode, ContentType.. gibi methodları kullanıyoruz.
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).//“completed” is false
                body("userId",equalTo(2));//“userId” is 2

        /*
        Api üzerinde Body içerisinde yer almayan değerler için herhangi bir ekstra methoda gerek duymadan assert yapılırken,
        Body içerisinde yer alan değerler için body() methodu ile birlikte Matchers kullanılarak assert yapılır.
        */
        //2. Yol - Soft assertion body için
                response.//equalTo methodu ile body içerisinde bulunan değerler için assertion yapıyoruz
                then().//metadata bulunan değerler için ise statusCode, ContentType.. gibi methodları kullanıyoruz.
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId",equalTo(2));
        /*
        -Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz.
        Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
        -Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çalışmayı durdurur.
         */

    }


}
