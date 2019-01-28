package xmljson;


import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

import static org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON;


public class JSONviaMarshaller {
    public static void main(String[] args) throws Exception {
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

        try {
            File file = new File("src/main/resources/group.json");
            System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, APPLICATION_JSON);
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
            jaxbMarshaller.marshal(mateGroup, file);
            jaxbMarshaller.marshal(mateGroup, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

