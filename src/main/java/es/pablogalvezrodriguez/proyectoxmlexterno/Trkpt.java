
package es.pablogalvezrodriguez.proyectoxmlexterno;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Trkpt {
    private double lat;
    private double lon;
    private String time;
    
    public Trkpt () {
        
    }
    
    public String getTime() {
        return time;
    }

    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setTime(String time) {
        this.time = time;
    }
    
    public double getLat() {
        return lat;
    }
    
    @XmlAttribute
    public double setLat (double lat) {
        return this.lat = lat;
    }
    
    public double getLon() {
        return lon;
    }
    
    @XmlAttribute
    public double setLon (double lon) {
        return this.lon = lon;
    }
    
}
