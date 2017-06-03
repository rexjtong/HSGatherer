package gatherer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class Application {

    private static final String DATABASE_URL = "https://hsgatherer.firebaseio.com/";
    public static DatabaseReference database;

    public static void main(String[] args) throws IOException {
        // Initialize Firebase
        try {
            // [START initialize]
            FileInputStream serviceAccount = new FileInputStream("C:/Rex Tong/Work/HSGatherer/src/main/java/gatherer/hsgatherer-firebase-adminsdk-n5sl9-6f0a4fea2a.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                    .setDatabaseUrl(DATABASE_URL)
                    .build();
            FirebaseApp.initializeApp(options);
            // [END initialize]
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: invalid service account credentials. See README.");
            System.out.println(e.getMessage());

            System.exit(1);
        }

        // Shared Database reference
        database = FirebaseDatabase.getInstance().getReference();

        SpringApplication.run(Application.class, args);
    }
}