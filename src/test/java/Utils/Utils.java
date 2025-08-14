package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void doScroll(WebDriver driver, int firstPos, int lastPos){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+firstPos+", "+lastPos+")");
    }

    public void saveUsers(String firstName, String lastName, String userName, String password) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
       JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));


        JSONObject userObj  = new JSONObject();
        userObj.put("firstName",firstName);
        userObj.put("lastName",lastName);
        userObj.put("userName",userName);
        userObj.put("password",password);

        jsonArray.add(userObj);

        FileWriter writer= new FileWriter(fileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();

    }
}
