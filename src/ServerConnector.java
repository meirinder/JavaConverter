import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerConnector {
    private String adress;
    private String resultJsonOrXML;

    public ServerConnector(String adress) {
        this.adress = adress;
        connection();
    }

    private void connection(){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(adress);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJsonOrXML = buffer.toString();
           // System.out.println(resultJsonOrXML);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResultJsonOrXML(){
        return resultJsonOrXML;
    }

}
