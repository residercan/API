package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    /*
    Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",21.0);
        expectedData.put("title","Wash the dishes");
        expectedData.put("completed",false);
    */

    public Map<String, Object> expectedDataMethod(Integer userId, String title, Boolean completed){
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);

        return expectedData;

    }


}
