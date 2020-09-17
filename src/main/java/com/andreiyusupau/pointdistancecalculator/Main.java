package com.andreiyusupau.pointdistancecalculator;

import com.andreiyusupau.pointdistancecalculator.controller.PointController;
import com.andreiyusupau.pointdistancecalculator.dao.ConsoleInputPointDAO;
import com.andreiyusupau.pointdistancecalculator.dao.DAO;
import com.andreiyusupau.pointdistancecalculator.model.Point;
import com.andreiyusupau.pointdistancecalculator.service.DistanceCalculator;
import com.andreiyusupau.pointdistancecalculator.util.PointReader;
import com.andreiyusupau.pointdistancecalculator.view.ConsoleView;
import com.andreiyusupau.pointdistancecalculator.view.View;

public class Main {
    public static void main(String[] args) {
        PointReader pointReader=new PointReader();
        DAO<Point> pointDAO=new ConsoleInputPointDAO(pointReader);
        DistanceCalculator distanceCalculator=new DistanceCalculator(pointDAO);
        View view=new ConsoleView();
        PointController pointController=new PointController(distanceCalculator,view);
        pointController.comparePointDistances();
        pointReader.close();
    }
}
