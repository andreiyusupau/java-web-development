package com.andreiyusupau.xmlparser;

import com.andreiyusupau.xmlparser.model.Candies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) throws JAXBException {
//        XmlParser<Candy> parser= new StaxParser();
//      for(Candy candy: parser.parse("candies.xml")){
//          System.out.println(candy.toString());
//      }
        JAXBContext jc = JAXBContext.newInstance(Candies.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Candies candies = (Candies) unmarshaller.unmarshal(new File("candies.xml"));

        System.out.println(candies.toString());
//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(fosterHome, System.out);
    }
}
