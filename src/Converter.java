import java.util.Map;

public class Converter {
    private String fromValute;
    private String toValute;
    private double count;
    private double result;
    public Map<String,Item> itemStore;
    private  String ecbServ = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    private  String cbrServ = "https://www.cbr-xml-daily.ru/daily_json.js";
    private  String yahooServ = "https://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=json";

    public Converter(String fromValute, String toValute, double count,int nubmerOfBank) {
        this.fromValute = fromValute;
        this.toValute = toValute;
        this.count = count;
        switch (nubmerOfBank){
            case 1:
            {
                setJSONItemStore();
                break;
            }
            case 2:
            {
                setXMLItemStore();
                break;
            }
            default:
                setJSONItemStore();

        }
    }

    public void setFromValute(String valute){
        fromValute = valute;
    }

    public void setToValute(String valute){
        toValute = valute;
    }

    public void setCount(double count){
        this.count = count;
    }

    public double getResult(int bank){

        switch (bank){
            case 1:{
                convertCurrencyCBR();
                break;
            }
            case 2:{
                convertCurrencyECB();

                break;
            }
            default:
                convertCurrencyCBR();
        }
        return result;
    }

    private void setJSONItemStore(){
        ServerConnector r = new ServerConnector(cbrServ);
        Parser parser = new Parser(r.getResultJsonOrXML());
        itemStore = parser.fillItemStore();
    }


    private void setXMLItemStore(){
        XMLParser xmlParser = new XMLParser(ecbServ);
        itemStore = xmlParser.getResultMap();
    }

    private void convertCurrencyCBR(){
        result = count;
        result *= itemStore.get(fromValute).value;
        result /= itemStore.get(fromValute).nominal;
        result *= itemStore.get(toValute).nominal;
        result /= itemStore.get(toValute).value;
    }

    private void convertCurrencyECB(){
        result = count;
        double tmp = itemStore.get(toValute).value/itemStore.get(fromValute).value;
        result = count*tmp;
    }
}
