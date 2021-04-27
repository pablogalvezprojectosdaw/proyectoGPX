
package es.pablogalvezrodriguez.proyectoxmlexterno;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Metadata {
    
    private String name;
    
    public Metadata () {
        
    }
    
    public Metadata (String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setName(String name) {
        this.name = name;
    }
}
