
package es.pablogalvezrodriguez.proyectoxmlexterno;

import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class UtilGpx {
    
    public static Gpx pasarAObjeto ()  {
        
        File gpxFile = new File("prado-del-rey-a-torre-pajarete-y-vuelta-por-el-pilar-circula.gpx");
 
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Gpx.class);              
 
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
 
            Gpx ruta = (Gpx) jaxbUnmarshaller.unmarshal(gpxFile);
     
            System.out.println(ruta);
            
            return ruta;
            
        }
        catch (JAXBException e) 
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
