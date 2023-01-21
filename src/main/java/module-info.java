module at.ac.fhcampuswien.algorithms_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.management;

    opens at.ac.fhcampuswien.algorithms_javafx to javafx.fxml;
    exports at.ac.fhcampuswien.algorithms_javafx;

    exports at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;
    requires javafx.graphics;


}