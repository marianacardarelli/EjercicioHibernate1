module org.example.ejerciciohibernate1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;
    //requires java.sql;
    requires org.hibernate.orm.core;   // Hibernate (SessionFactory, Session, Configuration...)
    requires java.naming;



    opens org.example.ejerciciohibernate1 to javafx.fxml;
    exports org.example.ejerciciohibernate1;
    exports org.example.ejerciciohibernate1.data;
    opens org.example.ejerciciohibernate1.data to javafx.fxml;
}