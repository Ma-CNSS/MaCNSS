module application {
    requires org.postgresql.jdbc;
    requires java.sql;
    requires org.apache.commons.dbutils;
    requires mail;
    requires java.naming;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;
    requires cloudinary.core;


    opens application to javafx.fxml;
    exports application;

    opens application.Controllers to javafx.fxml;
    exports application.Controllers;

    opens application.DTO to org.apache.commons.dbutils;
    exports application.DTO;
}