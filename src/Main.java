import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Scanner in = new Scanner(System.in);
//        System.out.print("Начальная валюта: ");
//        String fromValute = in.nextLine();
//        System.out.print("Конечная валюта: ");
//        String toValute = in.nextLine();
//        System.out.print("Количество: ");
//        double count = in.nextDouble();
//        Converter converter = new Converter(fromValute,toValute,count);
//
//        System.out.println(converter.getResult());
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
        try {
            URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultJson);
        System.out.println();

        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(resultJson).getAsJsonObject();
        JsonObject valuteObj = mainObject.getAsJsonObject("Valute");
        System.out.println(valuteObj);
        System.out.println();
        System.out.println(valuteObj.getAsJsonObject("AUD"));
      //  JsonArray Valute = mainObject.getAsJsonArray("Valute");
//        for (JsonElement valute : Valute) {
//            JsonObject userObject = valute.getAsJsonObject();
//            System.out.println(userObject.get("EUR"));
//            if (userObject.get("p_id").getAsInt() == 132) {
//                System.out.println(userObject.get("p_name"));
//                return;
//            }
//        }
    }
}
