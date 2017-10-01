module modular.universe.application {

    requires modular.universe.service;
    requires modular.universe.ui;

    requires javafx.fxml;
    requires javafx.graphics;

    exports rtt.java9.code.sample.modular.universe.application to javafx.graphics;

}
