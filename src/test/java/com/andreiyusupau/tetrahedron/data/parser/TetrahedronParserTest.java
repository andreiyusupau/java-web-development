package com.andreiyusupau.tetrahedron.data.parser;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.model.Tetrahedron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TetrahedronParserTest {

    private final TetrahedronParser tetrahedronParser = new TetrahedronParser();

    @Test
    void parseShouldReturnATetrahedron() {
        String input = "(0.0, 0.5, 0.3), (2.6, 5.4, -2.4), (4.5, 3.6, -6.8), (5.6, 1.7, 5.9)";
        Tetrahedron parsedTetrahedron = tetrahedronParser.parse(input);
        Tetrahedron expectedTetrahedron = new Tetrahedron(
                new Point(0.0, 0.5, 0.3),
                new Point(2.6, 5.4, -2.4),
                new Point(4.5, 3.6, -6.8),
                new Point(5.6, 1.7, 5.9));
        assertEquals(expectedTetrahedron, parsedTetrahedron);
    }
}
