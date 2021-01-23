package com.andreiyusupau.xmlparser.parser;

import java.util.Collection;

public interface XmlParser<T> {

    Collection<T> parse(String inputXml);
}
