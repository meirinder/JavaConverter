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
}
