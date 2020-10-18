package com.andreiyusupau.tetrahedron.parser;

import com.andreiyusupau.tetrahedron.model.Point;
import com.andreiyusupau.tetrahedron.model.Tetrahedron;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TetrahedronParser implements Parser<Tetrahedron> {

    private static final String DECIMAL_REGEX = "-?\\d+(\\.\\d+)?";

    @Override
    public Tetrahedron parse(String input) {
        Pattern pattern=Pattern.compile(DECIMAL_REGEX);
        Matcher matcher=pattern.matcher(input);
        double [] pointData=new double[12];
        int iterator=0;
        while (matcher.find()){
           pointData[iterator]= Double.parseDouble(matcher.group());
           iterator++;
        }
        Point pointA=new Point(pointData[0],pointData[1],pointData[2]);
        Point pointB=new Point(pointData[3],pointData[4],pointData[5]);
        Point pointC=new Point(pointData[6],pointData[7],pointData[8]);
        Point pointD=new Point(pointData[9],pointData[10],pointData[11]);
        return new Tetrahedron(pointA,pointB,pointC,pointD);
    }
}
