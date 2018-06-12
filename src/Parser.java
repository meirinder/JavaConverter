import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Parser {
    private String JSON;
    private String[] allCharCodes;

    public Parser(String JSON) {
        this.JSON = JSON;
        allCharCodes = new String[]{"AUD", "AZN", "GBP", "AMD", "BYN", "BGN",
                                    "BRL", "HUF", "HKD", "DKK", "USD", "EUR", "INR",
                                    "KZT", "CAD", "KGS", "CNY", "MDL", "NOK", "PLN",
                                    "RON", "XDR", "SGD", "TJS", "TRY", "TMT", "UZS",
                                    "UAH", "CZK", "SEK", "CHF", "ZAR", "KRW", "JPY"};

    }

    public Map<String,Item> fillItemStore(){
        Map<String,Item> resultMap = new HashMap<String,Item>();
        Item RURinstanse = new Item("RUB","R00000",643,"Российский рубль",
                1,1,1);
        resultMap.put("RUB",RURinstanse);
        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(JSON).getAsJsonObject();
        JsonObject valuteObject = mainObject.getAsJsonObject("Valute");

        for (String allCharCode : allCharCodes) {
            JsonObject valute = valuteObject.getAsJsonObject(allCharCode);

            String charCode = valute.get("CharCode").getAsString();
            String ID = valute.get("ID").getAsString();
            String name = valute.get("Name").getAsString();
            int numCode = valute.get("NumCode").getAsInt();
            int value = valute.get("Value").getAsInt();
            int previous = valute.get("Previous").getAsInt();
            int nominal = valute.get("Nominal").getAsInt();

            Item instance = new Item(charCode,ID,numCode,name, value,previous, nominal);
            resultMap.put(allCharCode, instance);
        }
        return resultMap;
    }
}
