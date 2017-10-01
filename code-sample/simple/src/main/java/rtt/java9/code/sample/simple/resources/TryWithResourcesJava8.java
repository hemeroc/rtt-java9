package rtt.java9.code.sample.simple.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryWithResourcesJava8 {

    public static final String FXML_UNIVERSE_FXML = "/fxml/universe.fxml";

    public static void main(String[] args) throws IOException {
        final InputStream resourceAsStream = TryWithResourcesJava8.class.getResourceAsStream(FXML_UNIVERSE_FXML);
        final BufferedReader reader =
            new BufferedReader(new InputStreamReader(resourceAsStream));
        try (BufferedReader newReader = new BufferedReader(reader)) {
            System.out.println(FXML_UNIVERSE_FXML + " has " + newReader.lines().count() + " lines");
        }
    }

}
