package gmibank;

import base_urls.GmiBankBaseUrl;
import gmibank.pojos.Country;
import gmibank.pojos.States;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl {

    //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak
    // en az 3 "state" içeren bir "country" oluşturan bir otomasyon testi yazınız.

    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {

  "name": "Banana Republic",
  "states": [
    {
      "id": 1,
      "name": "Apple"
    },
    {
      "id": 2,
      "name": "Orange"
    },
    {
      "id": 3,
      "name": "Pear"
    }
     ]
    }
    When
        User send Post request
    Then
        Status code should be 201
    And
        {
    "id": 176681,
    "name": "Banana Republic",
    "states": [
        {
            "id": 1,
            "name": "Apple",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Orange",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "Pear",
            "tpcountry": null
        }
        ]
        }

     */

    @Test
    public void postCountry01(){
        //Set the Url
        spec.pathParams("first", "api", "second", "tp-countries");

        //Set the expected data

        States states1 = new States(1, "Apple", null);
        States states2 = new States(2, "Orange", null);
        States states3 = new States(3, "Pear", null);
        List<States> statesList = new ArrayList<>();
        statesList.add(states1);
        statesList.add(states2);
        statesList.add(states3);

        Country expectedData = new Country("Banana Republic", statesList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

        Country actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Country.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(states1.getId(), actualData.getStates().get(0).getId());
        assertEquals(states1.getName(), actualData.getStates().get(0).getName());
        assertEquals(states1.getTpcountry(), actualData.getStates().get(0).getTpcountry());

        assertEquals(states2.getId(), actualData.getStates().get(1).getId());
        assertEquals(states2.getName(), actualData.getStates().get(1).getName());
        assertEquals(states2.getTpcountry(), actualData.getStates().get(1).getTpcountry());

        assertEquals(states3.getId(), actualData.getStates().get(2).getId());
        assertEquals(states3.getName(), actualData.getStates().get(2).getName());
        assertEquals(states3.getTpcountry(), actualData.getStates().get(2).getTpcountry());

        assertEquals(expectedData.getName(), actualData.getName());


    }

}
