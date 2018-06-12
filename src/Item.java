public class Item {

    String charCode;
    String id;
    int numCode;
    String name;
    double value;
    int previous;
    double nominal;

    public Item(String charCode, String id, int numCode, String name, double value, int previous, double nominal) {
        this.charCode = charCode;
        this.id = id;
        this.numCode = numCode;
        this.name = name;
        this.value = value;
        this.previous = previous;
        this.nominal = nominal;
    }

    public Item(String charCode, double value) {
        this.charCode = charCode;
        this.value = value;
        this.nominal = 1;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getId() {
        return id;
    }

    public int getNumCode() {
        return numCode;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getPrevious() {
        return previous;
    }

    public double getNominal() {
        return nominal;
    }
}
