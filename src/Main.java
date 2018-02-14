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
//"https://www.cbr-xml-daily.ru/daily_json.js"

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        System.out.print("Начальная валюта: ");
        String fromValute = in.nextLine();
        System.out.print("Конечная валюта: ");
        String toValute = in.nextLine();
        System.out.print("Количество: ");
        double count = in.nextDouble();
        Converter converter = new Converter(fromValute,toValute,count);

        System.out.println(converter.getResult());

    }
}
