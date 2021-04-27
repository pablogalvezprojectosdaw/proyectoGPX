package es.pablogalvezrodriguez.proyectoxmlexterno;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class App extends Application {
        
    int lon;
    int lat;
    String loopPuntos;
    String loopPuntosHecho = "";
    
    
    private final double DEFAULT_LAT = 36.67969;
    private final double DEFAULT_LON = -5.44484;
    private final int DEFAULT_ZOOM = 15;
    
    private Label labelTrackName = new Label();
    private WebView webView = new WebView();
    private WebEngine webEngine = webView.getEngine();
    private Stage stage;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        BorderPane paneRoot = new BorderPane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Gpx gpx = UtilGpx.pasarAObjeto();
       
        URL urlWebMap = this.getClass().getResource("/web/mapa.html");
        webEngine.load(urlWebMap.toString());
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState)->{
            if(newState == Worker.State.SUCCEEDED ) {
                webEngine.executeScript("initMap("+DEFAULT_LAT+","+DEFAULT_LON+","+DEFAULT_ZOOM+")");
            }
        });
        paneRoot.setCenter(webView);
                
        Button buttonBrowse = new Button("Dibujar línea");
        buttonBrowse.setOnAction((t) -> {
            dibujarLinea(gpx);
        });
                
        HBox paneBottom = new HBox();
        paneBottom.setStyle("-fx-spacing:10px; -fx-padding:10px; -fx-alignment:center-left");                
        paneBottom.getChildren().add(buttonBrowse);
        paneBottom.getChildren().add(labelTrackName);
        paneRoot.setTop(paneBottom); 
        
        
        
        
        System.out.println(gpx.getTrk().getTrkseg().getTrkpt().get(0).getLat());
        
        
        
        
    }

    private void dibujarLinea(Gpx gpx) {
        for (int i = 0; i <= 109; i++) {
                lat = i;
                lon = i;
                
                loopPuntos = "["+ gpx.getTrk().getTrkseg().getTrkpt().get(lat).getLat()+","+gpx.getTrk().getTrkseg().getTrkpt().get(lon).getLon() + "]" + ",";
                loopPuntosHecho += loopPuntos;
                System.out.println(loopPuntosHecho);
                if (i == 109) {
                    loopPuntos = "["+ gpx.getTrk().getTrkseg().getTrkpt().get(lat).getLat()+","+gpx.getTrk().getTrkseg().getTrkpt().get(lon).getLon() + "]" ;
                    loopPuntosHecho += loopPuntos;
                    System.out.println(loopPuntosHecho);
                }
            
        }
        String r = "["+loopPuntosHecho+"]";
        System.out.println(r);
        //String r = "[[36.697180, -5.420622], [36.706072, -5.395577], [36.725436, -5.401271], [36.697167, -5.420589]]";
        webEngine.executeScript("clearTrack()");
        webEngine.executeScript("drawTrack("+r+")");
    }
                
    public static void main(String[] args) {
        launch();
    }
    
}