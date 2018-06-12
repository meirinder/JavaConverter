

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class XMLParser{

    private String  ecbServ;
    private  Map<String,Item> resultMap;

    public XMLParser(String ecbServ) {
        this.ecbServ = ecbServ;
        resultMap = new HashMap<String,Item>();
        try {
            InputStream is = new URL(ecbServ).openStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            NodeList nodeList = doc.getElementsByTagName("Cube");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String name = element.getAttribute("currency");
                    if (name.isEmpty() == true ) {
                        continue;
                    }
                    String rate = element.getAttribute("rate");
                    double value = Double.valueOf(rate);

                    Item item = new Item(name,value);
                    resultMap.put(name, item);
                }
            }
            resultMap.put("EUR", new Item("EUR",1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, Item> pair : resultMap.entrySet())
        {
            double value = pair.getValue().value;
            String charcode = pair.getKey();
            System.out.println(value);
            System.out.println(charcode);
        }
    }

    public Map<String, Item> getResultMap() {
        return resultMap;
    }
}