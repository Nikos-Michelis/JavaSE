import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        Gson gson = builder.create();

        String json = null;
        try {
            json = Files.readString(Path.of("ob.json"));
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // read
        Widget javaObject = gson.fromJson(json, Widget.class);
        // doesn't ignore the null fields and serialize that field to new file ob2.json
        javaObject.setImage(null);
        System.out.println(javaObject);
        // write
        json = gson.toJson(javaObject);
        try {
            Files.writeString(Path.of("ob2.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}