package com.andreiyusupau.necklacemaker;

import com.andreiyusupau.necklacemaker.controller.NecklaceController;
import com.andreiyusupau.necklacemaker.dao.DAO;
import com.andreiyusupau.necklacemaker.dao.DAOFactory;
import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.service.NecklaceBuilder;
import com.andreiyusupau.necklacemaker.service.NecklaceCalculator;
import com.andreiyusupau.necklacemaker.service.NecklaceService;
import com.andreiyusupau.necklacemaker.util.PropertiesLoader;
import com.andreiyusupau.necklacemaker.view.View;
import com.andreiyusupau.necklacemaker.view.ViewFactory;

public class Main {

    private static final String DAO_TYPE="dao.type";
    private static final String VIEW_TYPE="view.type";

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        DAO<Gem> gemDAO= DAOFactory.getDAO(propertiesLoader.getProperty(DAO_TYPE));
        NecklaceBuilder necklaceBuilder= new NecklaceBuilder();
        NecklaceCalculator necklaceCalculator=new NecklaceCalculator();
        NecklaceService necklaceService=new NecklaceService(necklaceBuilder,necklaceCalculator,gemDAO);
        View view= ViewFactory.getView(propertiesLoader.getProperty(VIEW_TYPE));
        NecklaceController necklaceController= new NecklaceController(necklaceService,view);
        necklaceController.init();
    }
}
