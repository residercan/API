package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static void main(String[] args) {
        System.out.println("generateToken() = " + generateToken());
    }
    /*
    {
     "password": "string",
     "rememberMe": true,
     "username": "string"
    }
     */

    public static String generateToken(){

        Map<String, Object> postBody = new HashMap<>();
        postBody.put("password", "Batch.103");
        postBody.put("rememberMe", true);
        postBody.put("username", "batch_yuzuc");

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");

    }


}
