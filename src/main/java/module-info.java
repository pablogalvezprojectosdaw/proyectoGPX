module es.pablogalvezrodriguez.proyectoxmlexterno {
    requires javafx.controls;
    exports es.pablogalvezrodriguez.proyectoxmlexterno;
    requires javafx.webEmpty;
    requires javafx.web;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    opens es.pablogalvezrodriguez.proyectoxmlexterno to java.xml.bind;
}
