package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="Candies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candies {
    @XmlElements({
            @XmlElement(name = "Chocolate", type = Chocolate.class),
            @XmlElement(name = "Hard-candy", type = HardCandy.class),
            @XmlElement(name = "Liquorice", type = Liquorice.class),
            @XmlElement(name = "Marshmallow", type = Marshmallow.class),
            @XmlElement(name = "Toffee", type = Toffee.class),
    })
    private List<Candy> candies;

    @Override
    public String toString() {
        return "Candies{" +
                "candies=" + candies +
                '}';
    }
}
