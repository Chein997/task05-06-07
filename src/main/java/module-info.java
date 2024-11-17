module com.chein.task6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires junit;
    requires org.slf4j;
    requires org.assertj.core;


    opens com.chein.task6 to javafx.fxml;
    exports com.chein.task6;
    exports com.chein.task6.test;
}