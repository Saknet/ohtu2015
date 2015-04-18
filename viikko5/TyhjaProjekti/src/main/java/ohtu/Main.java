package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014140228";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int totalHours = 0;
        int totalExercises = 0;
        System.out.println("opiskelijanumero " + studentNr );
        System.out.println("");
        
        for (Submission submission : subs) {
            totalHours += submission.getHours();
            System.out.println(submission.toString());
            totalExercises += submission.getDone();
        }
        System.out.println("");
        System.out.println("yhteensä: " + totalExercises + " tehtävää " + totalHours + " tuntia");
    }
}
