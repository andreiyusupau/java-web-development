package com.andreiyusupau.xmlparser.parser;

import com.andreiyusupau.xmlparser.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DomParser implements XmlParser<Candy> {

    @Override
    public Collection<Candy> parse(String inputXml) {
        File xmlFile = new File(inputXml);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement()
                    .normalize();
            NodeList nodeList = document.getDocumentElement()
                    .getChildNodes();
            List<Candy> candies = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    candies.add(getCandy(nodeList.item(i)));
                }
            }
            return candies;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new ParserException("Error parsing file.");
        }
    }

    private Candy getCandy(Node node) {
        long id = Long.parseLong(node.getAttributes()
                .item(0)
                .getNodeValue()
                .substring(3));
        String name = "";
        int energy = 0;
        double proteins = 0;
        double fats = 0;
        double carbohydrates = 0;
        String production = "";
        String country = "";
        NodeList candyChildren = node.getChildNodes();
        for (int i = 0; i < candyChildren.getLength(); i++) {
            Node parameter = candyChildren.item(i);
            if (parameter.getNodeType() == Node.ELEMENT_NODE) {
                switch (parameter.getNodeName()) {
                    case "Name":
                        name = parameter.getTextContent();
                        break;
                    case "Energy":
                        energy = Integer.parseInt(parameter.getTextContent());
                        break;
                    case "Value": {
                        proteins = Double.parseDouble(parameter.getChildNodes()
                                .item(1)
                                .getTextContent());
                        fats = Double.parseDouble(parameter.getChildNodes()
                                .item(3)
                                .getTextContent());
                        carbohydrates = Double.parseDouble(parameter.getChildNodes()
                                .item(5)
                                .getTextContent());
                    }
                    break;
                    case "Production": {
                        production = parameter.getTextContent();
                        country = parameter.getAttributes()
                                .getNamedItem("country")
                                .getTextContent();
                    }
                    break;
                    case "Ingredients": {
                        return parseCandy(node, parameter, id, name, energy, proteins, fats, carbohydrates, production, country);
                    }
                    default:
                        throw new ParserException("No such candy");
                }
            }
        }
        throw new ParserException("No such candy");
    }

    private Candy parseCandy(Node node, Node parameter, long id, String name, int energy, double proteins, double fats, double carbohydrates, String production, String country) {

        NodeList ingredientsChildren = parameter.getChildNodes();
        int water = Integer.parseInt(ingredientsChildren.item(1)
                .getTextContent());
        boolean preparedWater = false;
        if (ingredientsChildren.item(1)
                .getAttributes().getLength() != 0) {
            preparedWater = Boolean.parseBoolean(ingredientsChildren.item(1)
                    .getAttributes()
                    .getNamedItem("prepared")
                    .getTextContent());
        }
        int sugar = Integer.parseInt(ingredientsChildren.item(3)
                .getTextContent());
        String sugarType = "white";
        if (ingredientsChildren.item(3)
                .getAttributes()
                .getLength() != 0) {
            sugarType = ingredientsChildren.item(3)
                    .getAttributes()
                    .getNamedItem("type")
                    .getTextContent();
        }
        switch (node.getNodeName()) {
            case "Chocolate": {
                int chocolate = Integer.parseInt(ingredientsChildren.item(5)
                        .getTextContent());
                Chocolate.ChocolateType chocolateType = Chocolate.ChocolateType.valueOf(ingredientsChildren.item(5)
                        .getAttributes()
                        .getNamedItem("type")
                        .getTextContent()
                        .toUpperCase());
                int nuts = 0;
                String nutsType = "";
                if (ingredientsChildren.getLength() > 3) {
                    nuts = Integer.parseInt(ingredientsChildren.item(7)
                            .getTextContent());
                    nutsType = ingredientsChildren.item(7)
                            .getAttributes()
                            .getNamedItem("type")
                            .getTextContent();
                }
                return new Chocolate(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, chocolate, chocolateType, nuts, nutsType);
            }
            case "Hard-candy": {
                int citricAcid = Integer.parseInt(ingredientsChildren.item(5)
                        .getTextContent());
                return new HardCandy(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, citricAcid);
            }
            case "Liquorice": {
                int liquoriceExtract = Integer.parseInt(ingredientsChildren.item(5)
                        .getTextContent());
                int starch = Integer.parseInt(ingredientsChildren.item(7)
                        .getTextContent());
                return new Liquorice(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, liquoriceExtract, starch);
            }

            case "Marshmallow": {
                int gelatin = Integer.parseInt(ingredientsChildren.item(5)
                        .getTextContent());
                return new Marshmallow(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, gelatin);
            }
            case "Toffee": {
                int butter = Integer.parseInt(ingredientsChildren.item(5)
                        .getTextContent());
                int flour = Integer.parseInt(ingredientsChildren.item(7)
                        .getTextContent());
                return new Toffee(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country, butter, flour);
            }
            default:
                throw new ParserException("No such candy type");
        }
    }
}
