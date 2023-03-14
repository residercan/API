package get_requests;

import base_urls.HerOkurAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkurAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
{
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}

     */

    @Test
    public void get06(){
        //Set the URL
        spec.pathParams("first","booking","second",23);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//      Do Assertion
//      1. YOL
//        response.then().
//                statusCode(200).
//                contentType("application/json").
//                body("firstname", equalTo("Josh"),
//                        "lastname", equalTo("Allen"),
//                        "totalprice", equalTo(111),
//                        "depositpaid", equalTo(true),
//                        "bookingdates.checkin", equalTo("2018-01-01"),
//                        "bookingdates.checkout", equalTo("2019-01-01"),
//                        "additionalneeds", equalTo("midnight snack"));

        //2. YOL
        JsonPath jsonPath = response.jsonPath();
//        assertEquals("Josh", jsonPath.getString("firstname"));
//        assertEquals("Allen", jsonPath.getString("lastname"));
//        assertEquals(111, jsonPath.getInt("totalprice"));
//        assertTrue(jsonPath.getBoolean("depositpaid"));
//        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
//        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
//        assertEquals("additionalneeds", jsonPath.getString("midnight snack"));

        //3. YOL: Test NG Soft Assert

        //-- SoftAssert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

        //--Assertion
        softAssert.assertEquals(jsonPath.getString("firstname"), "Josh");
        softAssert.assertEquals(jsonPath.getString("lastname"), "Allen");
        softAssert.assertEquals(jsonPath.getInt("totalprice"), 111);
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"));
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2018-01-01");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2019-01-01");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"), "midnight snack");

        //--softAssert assertAll() diyerek doğrulamayı kontrol et. Aksi takdirde test hep "Pass" olur.
        softAssert.assertAll();





    }
}

