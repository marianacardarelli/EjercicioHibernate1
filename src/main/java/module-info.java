module org.example.ejerciciohibernate1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;   // Hibernate (SessionFactory, Session, Configuration...)
    requires mysql.connector.j;        // driver de MySQL
    requires java.naming;
    requires java.sql;

    opens org.example.ejerciciohibernate1 to javafx.fxml;
    exports org.example.ejerciciohibernate1;
    // Hibernate tiene que poder leer los atributos privados de Equipo
    opens org.example.ejerciciohibernate1.models to org.hibernate.orm.core;
}