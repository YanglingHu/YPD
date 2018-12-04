package YPD.Model.acc;
import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Verify the reliability doctor by the NPI-license. 
 * 
 * @Date 2018/11/22
 * @author Yi Qiu
 */
public class Verification {
    
    private final static String HEAD = "https://api.betterdoctor.com/2016-03-01/doctors/npi/";
    private final static String TAIL = "?user_key=fd858f824e044e1dd856b4b362f367f5";
    
    /**
     * Returns a map if the doctor is valid, else returns null.
     * 
     * @param _firstname doctor's first name.
     * @param _NPI doctor license.
     * @return map that stores the first name, picture and gender of the doctor.
     * @throws JSONException if a JSONException occurs.
     */
    public static Map<String,String> checkForDoctor(String _firstname, String _NPI) throws JSONException {
        String verified = getDoctorInfo(Integer.parseInt(_NPI));
        
        if(verified.equals("Verfication failed")||verified.equals("Doctor Not Found")){
            System.out.println(verified);
            return null;
        }else{
            Map<String,String> map = parseJson(verified);
            if(map.get("first_name").equals(_firstname)){
                System.out.println("Verication pass!");
                return map;
            }
            System.out.println("Please make sure your name and NPI matches each other");
            return null;
        }                        
    }

    /**
     * Processes the Json file and stores the critical information into a map.
     * 
     * @param _json String of json data.
     * @return map thastores the first name, picture and gender of the doctor.
     * @throws JSONException if a JSONException occurs.t stores the first name, picture and gender of the doctor.
     * @throws JSONException if a JSONException occurs.
     */
    public static Map<String,String> parseJson(String _json) throws JSONException{
        JSONObject obj = new JSONObject(_json);
        obj = obj.getJSONObject("data");
        Map<String,String> map = new HashMap<>();
        map.put("first_name", obj.getJSONObject("profile").getString("first_name"));
        map.put("img", obj.getJSONObject("profile").getString("image_url"));
        map.put("gender", obj.getJSONObject("profile").getString("gender"));
        return map;
    }
    
    /**
     * Gets doctor information through the NPI license.
     * 
     * @param _NPI doctor license.
     * @return json data that is in String format.
     */
    public static String getDoctorInfo(int _NPI) {
        StringBuilder info = new StringBuilder();
        String query = HEAD + _NPI + TAIL;
        try {
            URL API = new URL(query);
            URLConnection connection = API.openConnection();
            InputStream temp = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                info.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            return "Verfication failed";
        } catch (IOException e) {
            return "Doctor Not Found";
        }
        return info.toString();
    }
}
