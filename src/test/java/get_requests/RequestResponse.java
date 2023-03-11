package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1) Posmtman manuel API testi için kullanılır.
    2) API otomasyonu için Rest-Assured Library kullanılır.
    3) Otomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama,
        b) Test case'i yazma:
            - Test case'i yazmak için 'Gherkin Language' kullanırız.
            * Given: Ön koşullar --> Endpoint, body
            * When: İşlemler --> Get, Put, Delete ...
            * Then: Dönütler --> Assert
            * And: Çoklu işlemlerin art arda yazılacağı yerlerde kullanılır.
        c) Test kodunu yazarken şu adımları izleriz
            * Set the Url
            * Set the expected data
            * Send the request and get the response
            * Do assertion
     */


    public static void main(String[] args) {

        String url = "https://restful-booker.herokuapp.com/booking/55";
        // Get request nasıl yapılır:
        Response response = given().when().get(url);

        response.prettyPrint();//prettyPrint() methodu response datayı yazdırır

        //Status Code nasıl yazdırılır.
        System.out.println("Status Code: " + response.statusCode());

        //Content Type nasıl yazdırılır.
        System.out.println("Content Type: " + response.contentType());

        //Status Line nasıl yazdırılır.
        System.out.println("Status Line: " + response.statusLine());

        //Header nasıl yazdırılır.--> header() parantez içerisine neyi yazdırmak istiyorsak yazıyoruz
        System.out.println(response.header("Server"));
        System.out.println(response.header("Connection"));

        //Headers nasıl yazıdırılır. Headers ile header bölümünde bulunan herşeyi yazdırabiliriz.
        System.out.println(response.headers());

        //Time nasıl yazdırılır
        System.out.println("Time: " + response.time());

    }

}
