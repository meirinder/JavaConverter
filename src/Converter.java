import java.util.Map;

public class Converter {
    private String fromValute;
    private String toValute;
    private double count;
    private double result;
    private Map<String,Item> itemStore;

    public Converter(String fromValute, String toValute, double count) {
        this.fromValute = fromValute;
        this.toValute = toValute;
        this.count = count;
        setItemStore();
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

    public double getResult(){
        convertCurrency();
        return result;
    }

    private void setItemStore(){

    }

    private void convertCurrency(){
        result = count * 60;
    }
}
