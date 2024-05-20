module org.proyect.hibernatejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.transaction;


    opens org.proyect.hibernatejavafx to javafx.fxml;
    exports org.proyect.hibernatejavafx;
    exports org.proyect.hibernatejavafx.entities;
    opens org.proyect.hibernatejavafx.entities;
    exports org.proyect.hibernatejavafx.javafxcontrollers;
    opens org.proyect.hibernatejavafx.javafxcontrollers to javafx.fxml;
    exports org.proyect.hibernatejavafx.repositories;
    opens org.proyect.hibernatejavafx.repositories to javafx.fxml;
}

