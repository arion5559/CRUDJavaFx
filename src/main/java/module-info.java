module CRUDJavaFx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires java.prefs;
    requires java.naming;
    requires java.xml;
    requires java.base;
    requires java.logging;
    requires java.management;
    requires java.compiler;
    requires java.management.rmi;
    requires javafx.base;
    requires javafx.graphics;
    exports com.example.crudjavafx;
    opens com.example.crudjavafx to javafx.fxml;
}