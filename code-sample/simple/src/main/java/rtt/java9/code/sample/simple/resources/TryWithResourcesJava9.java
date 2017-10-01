package rtt.java9.code.sample.simple.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryWithResourcesJava9 {

    public static final String FXML_UNIVERSE_FXML = "/fxml/universe.fxml";

    public static void main(String[] args) throws IOException {
        final InputStream resourceAsStream = TryWithResourcesJava9.class.getResourceAsStream(FXML_UNIVERSE_FXML);
        final BufferedReader reader =
            new BufferedReader(new InputStreamReader(resourceAsStream));
        try (reader) {
            System.out.println(FXML_UNIVERSE_FXML + " has " + reader.lines().count() + " lines");
        }
    }


}
