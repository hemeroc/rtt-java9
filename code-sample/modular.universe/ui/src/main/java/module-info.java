module modular.universe.ui {

    requires modular.universe.service;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports rtt.java9.code.sample.modular.universe.ui;

    opens rtt.java9.code.sample.modular.universe.ui to javafx.fxml;

}
