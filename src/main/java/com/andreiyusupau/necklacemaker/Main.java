package com.andreiyusupau.necklacemaker;

import com.andreiyusupau.necklacemaker.controller.NecklaceController;
import com.andreiyusupau.necklacemaker.dao.DAO;
import com.andreiyusupau.necklacemaker.dao.DAOFactory;
import com.andreiyusupau.necklacemaker.model.Gem;
import com.andreiyusupau.necklacemaker.service.NecklaceBuilder;
import com.andreiyusupau.necklacemaker.service.NecklaceService;
import com.andreiyusupau.necklacemaker.util.PropertiesLoader;
import com.andreiyusupau.necklacemaker.view.View;
import com.andreiyusupau.necklacemaker.view.ViewFactory;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        DAO<Gem> gemDAO= DAOFactory.getDAO(propertiesLoader.getProperty("dao.type"));
        NecklaceBuilder necklaceBuilder= new NecklaceBuilder();
        NecklaceService necklaceService=new NecklaceService(necklaceBuilder,gemDAO);
        View view= ViewFactory.getView(propertiesLoader.getProperty("view.type"));
        NecklaceController necklaceController= new NecklaceController(necklaceService,view);
    }
}
