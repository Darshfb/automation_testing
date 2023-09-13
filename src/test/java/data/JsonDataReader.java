package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String firstName, lastName, email, phone, password;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jArray) {
            JSONObject person = (JSONObject) jsonObj;
            firstName = (String) person.get("firstName");
            System.out.println(firstName);

            lastName = (String) person.get("lastName");
            System.out.println(lastName);

            email = (String) person.get("email");
            System.out.println(email);

            phone = (String) person.get("phone");
            System.out.println(phone);

            password = (String) person.get("password");
            System.out.println(password);


        }
    }


}
