package com.andreiyusupau.xmlparser;

import com.andreiyusupau.xmlparser.model.Candy;
import com.andreiyusupau.xmlparser.parser.JaxbParser;
import com.andreiyusupau.xmlparser.parser.XmlParser;
import com.andreiyusupau.xmlparser.validator.Validator;

public class Main {

    public static final String FILE_NAME = "candies.xml";
    public static final String SCHEMA_NAME = "schema.xsd";

    public static void main(String[] args) {
        Validator validator=new Validator();
        validator.checkXMLDocument(FILE_NAME, SCHEMA_NAME);
        //XmlParser<Candy> parser= new StaxParser();
       // XmlParser<Candy> parser=new DomParser();
       XmlParser<Candy> parser=new JaxbParser();
      for(Candy candy: parser.parse(FILE_NAME)) {
          System.out.println(candy.toString());
      }
    }
}
