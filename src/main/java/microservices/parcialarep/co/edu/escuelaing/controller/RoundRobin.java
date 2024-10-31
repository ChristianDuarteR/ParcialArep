package microservices.parcialarep.co.edu.escuelaing.controller;

import microservices.parcialarep.co.edu.escuelaing.model.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


@RestController
@RequestMapping("/roundrobin")
public class RoundRobin {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "http://localhost:8080";


    @GetMapping
    public void determine(@RequestParam(value = "operation") String operation,
                                                  @RequestParam(value = "list") String[] list,
                                                  @RequestParam (value = "value") String value) throws IOException {
        if (operation.startsWith("linear")){
            GET_URL = "http://localhost:8080" + "linearsearch/?list="+list +"&value="+value;
        } else {
            GET_URL = "http://localhost:8080" + "binarysearch/?list="+list +"&value="+value;
        }

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }


}