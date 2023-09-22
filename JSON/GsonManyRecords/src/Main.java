import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Read a json from the web */
        String json = null;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            try (Scanner sc = new Scanner(url.openStream())) {
                sc.useDelimiter("\\A");
                json = sc.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);

        /* Create Gson */
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        // read and save object to array
        User[] usersArray = gson.fromJson(json, User[].class);
        System.out.println("_".repeat(20) + "Array:" + "_".repeat(20));
        System.out.println(Arrays.toString(usersArray));

        // read and save object to arrayList
        ArrayList<User> usersArraylist =
                new Gson().fromJson(json, new TypeToken<ArrayList<User>>() {}.getType());
        System.out.println("_".repeat(20) + "ArrayList:" + "_".repeat(20));
        System.out.println(usersArraylist);
    }
}