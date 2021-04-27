
package es.pablogalvezrodriguez.proyectoxmlexterno;

import javax.xml.bind.annotation.XmlElement;

public class Trk {
    
    private String name;
    private Trkseg trkseg;  
    
    
    public Trk () {
        
    }
    
    public String getName() {
        return name;
    }

    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setName(String name) {
        this.name = name;
    }

    public Trkseg getTrkseg() {
        return trkseg;
    }

    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setTrkseg(Trkseg trkseg) {
        this.trkseg = trkseg;
    }
    
}
