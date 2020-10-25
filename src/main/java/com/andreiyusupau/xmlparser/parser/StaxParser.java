package com.andreiyusupau.xmlparser.parser;

import com.andreiyusupau.xmlparser.model.*;

import javax.management.modelmbean.XMLParseException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class StaxParser implements XmlParser<Candy> {

    public Collection<Candy> parse(String inputXml) {
        String filename="candies.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
       try(FileInputStream fileInputStream=new FileInputStream(filename)) {
           XMLEventReader xmlEventReader= xmlInputFactory.createXMLEventReader(fileInputStream);
           Collection<Candy> candyCollection=new ArrayList<>();
           while (xmlEventReader.hasNext()){
               XMLEvent nextEvent = xmlEventReader.nextEvent();
               Candy candy;

           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (XMLStreamException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private Candy parseCandy(XMLEventReader xmlEventReader, XMLEvent nextEvent ) throws XMLStreamException {
        String startElementName;
        long id;
        String name;
        String energy;
        String proteins;
        String fats;
        String carbohydrates;
        String production;
        String country;
        String water;
        boolean waterPrepared;
        String sugar;
        String sugarType;

        if(nextEvent.isStartElement()){
            StartElement startElement=nextEvent.asStartElement();
            startElementName=startElement.getName()
                    .getLocalPart();
           id= Long.parseLong(startElement.getAttributeByName(new QName("id"))
                   .getValue());
            Characters nameCharacters=nextEvent.asCharacters();
            name=nameCharacters.getData();
           while (true){
               nextEvent=xmlEventReader.nextEvent();
               if(nextEvent.isStartElement()){
                   StartElement startElementInner=nextEvent.asStartElement();
                   String startElementInnerName= startElementInner.getName().getLocalPart();
                   nextEvent=xmlEventReader.nextEvent();
                   switch (startElementInnerName){
                       case "Name": name=nextEvent.asCharacters().getData();
                       break;
                       case "Energy": energy=nextEvent.asCharacters().getData();
                       break;
                       case "Value": {
                           while (true){
                               nextEvent=xmlEventReader.nextEvent();
                               if(nextEvent.isStartElement()){
                                   StartElement startElementValue=nextEvent.asStartElement();
                                   String startElementValueName= startElementValue.getName()
                                           .getLocalPart();
                                   nextEvent=xmlEventReader.nextEvent();
                                   switch (startElementValueName){
                                       case "Proteins":proteins=nextEvent.asCharacters()
                                               .getData();
                                       break;
                                       case "Fats":fats=nextEvent.asCharacters()
                                               .getData();
                                           break;
                                       case "Carbohydrates":carbohydrates=nextEvent.asCharacters()
                                               .getData();
                                           break;
                                   }
                               }else if(nextEvent.isEndElement()){
                                   EndElement endElement=nextEvent.asEndElement();
                                   if(endElement.getName()
                                           .getLocalPart()
                                           .equals("Value")){
                                       break;
                                   }
                               }
                           }
                       }
                       break;
                       case "Production": {
                           StartElement productionStartElement=nextEvent.asStartElement();
                           country=productionStartElement.getAttributeByName(new QName("country"))
                                   .getValue();
                           nextEvent=xmlEventReader.nextEvent();
                           production=nextEvent.asCharacters()
                                   .getData();
                       }
                       break;
                       case "Ingredients":{

                       }
                       break;
                   }
               }


           }


        }
        nextEvent=xmlEventReader.nextEvent();
        if (nextEvent.isAttribute()){
            Attribute attribute=nextEvent.
        }

        switch (startElementName){
            case "Chocolate":{
                String cocoa;
                String chocolateType;
                String nuts;
                String nutsType;
                return new Chocolate();
            }
            case "Hard-candy":{
               String citricAcid;
                return new HardCandy();
            }

            case "Liquorice":{
                String liquoriceExtract;
                String starch;
                return new Liquorice();
            }

            case "Marshmallow":{
                String gelatin;
                return new Marshmallow();
            }

            case "Toffee":{
                String butter;
                     String   flour;
                return new Toffee();
            }

            default:
                throw new ParserException("No such candy type.");
        }
    }


}
