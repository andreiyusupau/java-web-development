package com.andreiyusupau.xmlparser.parser;

import com.andreiyusupau.xmlparser.model.Candies;
import com.andreiyusupau.xmlparser.model.Candy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;

public class JaxbParser implements XmlParser<Candy> {
    @Override
    public Collection<Candy> parse(String inputXml) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Candies candies = (Candies) unmarshaller.unmarshal(new File(inputXml));
            return candies.getCandies();
        } catch (JAXBException e) {
            throw new ParserException("Error parsing file.",e);
        }
    }
}
