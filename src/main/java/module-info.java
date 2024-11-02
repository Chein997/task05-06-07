module com.chein.task5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires junit;
    requires org.slf4j;


    opens com.chein.task5 to javafx.fxml;
    exports com.chein.task5;
    exports com.chein.task5.test;
}