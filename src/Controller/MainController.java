package Controller;

import http.Http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
    
    
     private static final String PAGE = "https://www.york.ac.uk/teaching/cws/wws/webpage1.html";
    
    public static void printConsolePage() {
        String urlText = PAGE;
        BufferedReader in = null;
        try {
            URL url = new URL(urlText);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
           System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void downloadPage() {
        try (
            InputStream openStream = new URL(PAGE).openStream();
            Scanner scanner = new Scanner(openStream, "UTF-8");) {
            String out = scanner.useDelimiter("\\A").next();
            System.out.println(out);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getStatusFromPage() {
        try {
            String urltext = PAGE;
            URL url = new URL(urltext);
            int responseCode = ((HttpURLConnection) url.openConnection())
                    .getResponseCode();
            System.out.println(responseCode);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Http.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Http.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getConnection(){
        HttpURLConnection urlConnection;
        BufferedReader readBuffer;  
        StringBuilder stringBuilder;      
        OutputStreamWriter outputStreamWriter;
        String line;
        
        try {
            URL serverAddress = new URL(PAGE);
          
            urlConnection = (HttpURLConnection) serverAddress.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setReadTimeout(3000);
            urlConnection.connect();
        
            readBuffer  = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            stringBuilder = new StringBuilder();
        
            while ((line = readBuffer.readLine()) != null)
            {
                StringBuilder append = stringBuilder.append(line).append('\n');
            }        
            System.out.println(stringBuilder.toString());
                    
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (ProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }        
    }
}
