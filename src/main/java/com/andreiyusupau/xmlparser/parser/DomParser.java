package com.andreiyusupau.xmlparser.parser;

import com.andreiyusupau.xmlparser.model.Candy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DomParser implements XmlParser<Candy> {
    @Override
    public Collection<Candy> parse(String inputXml) {
        String filepath = "candies.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            // получаем узлы с именем Language
            // теперь XML полностью загружен в память
            // в виде объекта Document
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            // создадим из него список объектов Language
            List<Candy> langList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                langList.add(getCandy(nodeList.item(i)));
            }

            // печатаем в консоль информацию по каждому объекту Language
            for (Candy lang : langList) {
                System.out.println(lang.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // создаем из узла документа объект Language
    private static Candy getCandy(Node node) {
        Candy candy;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            lang.setName(getTagValue("name", element));
            lang.setAge(Integer.parseInt(getTagValue("age", element)));
        }

        return lang;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}
