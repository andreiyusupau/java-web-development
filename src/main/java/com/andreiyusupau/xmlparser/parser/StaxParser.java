package com.andreiyusupau.xmlparser.parser;

import com.andreiyusupau.xmlparser.model.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StaxParser implements XmlParser<Candy> {

    public Collection<Candy> parse(String inputXml) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(inputXml)) {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(fileInputStream);
            Collection<Candy> candyCollection = new ArrayList<>();
            while (xmlEventReader.hasNext()) {
                XMLEvent nextEvent = xmlEventReader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    if (startElement.getAttributeByName(new QName("id")) != null) {
                        Candy candy = parseCandy(xmlEventReader, nextEvent);
                        candyCollection.add(candy);
                    }
                }
            }
            return candyCollection;
        } catch (FileNotFoundException e) {
            throw new ParserException("File not found.", e);
        } catch (XMLStreamException e) {
            throw new ParserException("XML exception.", e);
        } catch (IOException e) {
            throw new ParserException("Error reading file.", e);
        }

    }

    private Candy parseCandy(XMLEventReader xmlEventReader, XMLEvent nextEvent) throws XMLStreamException {
        Map<String, String> candyParameters = new HashMap<>();
        if (nextEvent.isStartElement()) {
            StartElement startElement = nextEvent.asStartElement();
            candyParameters.put("class", startElement.getName()
                    .getLocalPart());
            candyParameters.put("id", startElement.getAttributeByName(new QName("id"))
                    .getValue());
            while (true) {
                nextEvent = xmlEventReader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElementInner = nextEvent.asStartElement();
                    String startElementInnerName = startElementInner.getName()
                            .getLocalPart();

                    switch (startElementInnerName) {
                        case "Name": {
                            nextEvent = xmlEventReader.nextEvent();
                            candyParameters.put("name", nextEvent.asCharacters().getData());
                        }
                            break;
                        case "Energy":{
                            nextEvent = xmlEventReader.nextEvent();
                            candyParameters.put("energy", nextEvent.asCharacters().getData());
                        }
                            break;
                        case "Value":
                            parseValue(xmlEventReader, candyParameters);
                            break;
                        case "Production":
                            parseProduction(nextEvent, xmlEventReader, candyParameters);
                            break;
                        case "Ingredients":
                            parseIngredients(xmlEventReader, candyParameters);
                            break;
                    }
                } else if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName()
                            .getLocalPart()
                            .equals(startElement.getName()
                                    .getLocalPart())) {
                        return initCandy(candyParameters);
                    }
                }
            }
        } else {
            throw new ParserException("Not a candy.");
        }
    }

    private Candy initCandy(Map<String, String> candyParameters) {
        long id = Long.parseLong(candyParameters.get("id")
                .substring(3));
        String name = candyParameters.get("name");
        int energy = Integer.parseInt(candyParameters.get("energy"));
        int water = Integer.parseInt(candyParameters.get("water"));
        boolean preparedWater = Boolean.parseBoolean(candyParameters.get("preparedWater"));
        int sugar = Integer.parseInt(candyParameters.get("sugar"));
        String sugarType = candyParameters.get("sugarType");
        double proteins = Double.parseDouble(candyParameters.get("proteins"));
        double fats = Double.parseDouble(candyParameters.get("fats"));
        double carbohydrates = Double.parseDouble(candyParameters.get("carbohydrates"));
        String production = candyParameters.get("production");
        String country = candyParameters.get("country");

        switch (candyParameters.get("class")) {
            case "Chocolate": {
                int cocoa = Integer.parseInt(candyParameters.get("chocolate"));
                Chocolate.ChocolateType chocolateType = Chocolate.ChocolateType.valueOf(candyParameters.get("chocolateType")
                        .toUpperCase());
                int nuts=0;
                if(candyParameters.get("nuts")!=null){
                    nuts= Integer.parseInt(candyParameters.get("nuts"));
                }
                String nutsType = candyParameters.get("nutsType");
                return new Chocolate(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, cocoa, chocolateType, nuts, nutsType);
            }
            case "Hard-candy": {
                int citricAcid = Integer.parseInt(candyParameters.get("citricAcid"));
                return new HardCandy(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, citricAcid);
            }
            case "Liquorice": {
                int liquoriceExtract = Integer.parseInt(candyParameters.get("liquoriceExtract"));
                int starch = Integer.parseInt(candyParameters.get("starch"));
                return new Liquorice(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, liquoriceExtract, starch);
            }
            case "Marshmallow": {
                int gelatin = Integer.parseInt(candyParameters.get("gelatin"));
                return new Marshmallow(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, gelatin);
            }
            case "Toffee": {
                int butter = Integer.parseInt(candyParameters.get("butter"));
                int flour = Integer.parseInt(candyParameters.get("flour"));
                return new Toffee(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, butter, flour);
            }
            default:
                throw new ParserException("No such candy.");
        }
    }


    private void parseValue(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementValue = nextEvent.asStartElement();
                String startElementValueName = startElementValue.getName()
                        .getLocalPart();
                nextEvent = xmlEventReader.nextEvent();
                switch (startElementValueName) {
                    case "Proteins":
                        candyParameters.put("proteins", nextEvent.asCharacters()
                                .getData());
                        break;
                    case "Fats":
                        candyParameters.put("fats", nextEvent.asCharacters()
                                .getData());
                        break;
                    case "Carbohydrates":
                        candyParameters.put("carbohydrates", nextEvent.asCharacters()
                                .getData());
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Value")) {
                    break;
                }
            }
        }
    }

    private void parseProduction(XMLEvent nextEvent, XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        StartElement productionStartElement = nextEvent.asStartElement();
        candyParameters.put("country", productionStartElement.getAttributeByName(new QName("country"))
                .getValue());
        nextEvent = xmlEventReader.nextEvent();
        candyParameters.put("production", nextEvent.asCharacters()
                .getData());
    }

    private void parseIngredients(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        switch (candyParameters.get("class")) {
            case "Chocolate":
                parseChocolate(xmlEventReader, candyParameters);
                break;
            case "Hard-candy":
                parseHardCandy(xmlEventReader, candyParameters);
                break;
            case "Liquorice":
                parseLiquorice(xmlEventReader, candyParameters);
                break;
            case "Marshmallow":
                parseMarshmallow(xmlEventReader, candyParameters);
                break;
            case "Toffee":
                parseToffee(xmlEventReader, candyParameters);
                break;
        }
    }

    private void parseChocolate(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementIngredients = nextEvent.asStartElement();
                String startElementIngredientsName = startElementIngredients.getName()
                        .getLocalPart();
                switch (startElementIngredientsName) {
                    case "Water":
                        parseWater(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Sugar":
                        parseSugar(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Chocolate":
                        parseCocoa(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Nuts":
                        parseNuts(nextEvent, xmlEventReader, candyParameters);
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Ingredients")) {
                    break;
                }
            }
        }
    }

    private void parseHardCandy(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementIngredients = nextEvent.asStartElement();
                String startElementIngredientsName = startElementIngredients.getName()
                        .getLocalPart();
                switch (startElementIngredientsName) {
                    case "Water":
                        parseWater(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Sugar":
                        parseSugar(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Citric-acid": {
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("citricAcid", nextEvent.asCharacters()
                                .getData());
                    }

                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Ingredients")) {
                    break;
                }
            }
        }
    }

    private void parseLiquorice(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementIngredients = nextEvent.asStartElement();
                String startElementIngredientsName = startElementIngredients.getName()
                        .getLocalPart();
                switch (startElementIngredientsName) {
                    case "Water":
                        parseWater(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Sugar":
                        parseSugar(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Liquorice-extract":{
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("liquoriceExtract", nextEvent.asCharacters()
                                .getData());
                    }

                        break;
                    case "Starch":{
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("starch", nextEvent.asCharacters()
                                .getData());
                    }
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Ingredients")) {
                    break;
                }
            }
        }
    }

    private void parseMarshmallow(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementIngredients = nextEvent.asStartElement();
                String startElementIngredientsName = startElementIngredients.getName()
                        .getLocalPart();
                switch (startElementIngredientsName) {
                    case "Water":
                        parseWater(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Sugar":
                        parseSugar(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Gelatin":{
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("gelatin", nextEvent.asCharacters()
                                .getData());
                    }
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Ingredients")) {
                    break;
                }
            }
        }
    }

    private void parseToffee(XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        while (true) {
            XMLEvent nextEvent = xmlEventReader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElementIngredients = nextEvent.asStartElement();
                String startElementIngredientsName = startElementIngredients.getName()
                        .getLocalPart();
                switch (startElementIngredientsName) {
                    case "Water":
                        parseWater(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Sugar":
                        parseSugar(nextEvent, xmlEventReader, candyParameters);
                        break;
                    case "Butter":{
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("butter", nextEvent.asCharacters()
                                .getData());
                    }
                        break;
                    case "Flour":{
                        nextEvent = xmlEventReader.nextEvent();
                        candyParameters.put("flour", nextEvent.asCharacters()
                                .getData());
                    }
                        break;
                }
            } else if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName()
                        .getLocalPart()
                        .equals("Ingredients")) {
                    break;
                }
            }
        }
    }

    private void parseWater(XMLEvent nextEvent, XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        StartElement waterStartElement = nextEvent.asStartElement();
        if(waterStartElement.getAttributes()
                .hasNext()){
            candyParameters.put("preparedWater",  waterStartElement.getAttributeByName(new QName("prepared"))
                    .getValue());
        }else {
            candyParameters.put("preparedWater",  "false");
        }
        nextEvent = xmlEventReader.nextEvent();
        candyParameters.put("water", nextEvent.asCharacters()
                .getData());
    }

    private void parseSugar(XMLEvent nextEvent, XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        StartElement sugarStartElement = nextEvent.asStartElement();
        if(sugarStartElement.getAttributes()
                .hasNext()){
            candyParameters.put("sugarType", sugarStartElement.getAttributeByName(new QName("type"))
                    .getValue());
        }else {
            candyParameters.put("sugarType",  "white");
        }
        nextEvent = xmlEventReader.nextEvent();
        candyParameters.put("sugar", nextEvent.asCharacters()
                .getData());
    }

    private void parseCocoa(XMLEvent nextEvent, XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        StartElement sugarStartElement = nextEvent.asStartElement();
        candyParameters.put("chocolateType", sugarStartElement.getAttributeByName(new QName("type"))
                .getValue());
        nextEvent = xmlEventReader.nextEvent();
        candyParameters.put("chocolate", nextEvent.asCharacters()
                .getData());
    }

    private void parseNuts(XMLEvent nextEvent, XMLEventReader xmlEventReader, Map<String, String> candyParameters) throws XMLStreamException {
        StartElement sugarStartElement = nextEvent.asStartElement();
        if(sugarStartElement.getAttributes()
                .hasNext()){
            candyParameters.put("nutsType", sugarStartElement.getAttributeByName(new QName("type"))
                    .getValue());
        }else {
            candyParameters.put("nutsType",  "");
        }
        nextEvent = xmlEventReader.nextEvent();
        candyParameters.put("nuts", nextEvent.asCharacters()
                .getData());
    }
}