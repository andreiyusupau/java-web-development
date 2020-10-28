package com.andreiyusupau.xmlparser.validator;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {

        public void checkXMLDocument(String fileName, String schemaName) {
            Source source = new StreamSource(fileName);
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            try {
                Schema schema = factory.newSchema(new File(schemaName));
                javax.xml.validation.Validator validator = schema.newValidator();
                validator.validate(source);
            } catch (SAXException e) {
                throw new ValidationException("Invalid file",e);
            } catch (IOException e) {
                throw new ValidationException("Error reading file",e);
            }
        }
}
