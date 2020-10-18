package com.andreiyusupau.tetrahedron.data;

import com.andreiyusupau.tetrahedron.model.Tetrahedron;
import com.andreiyusupau.tetrahedron.parser.Parser;
import com.andreiyusupau.tetrahedron.validation.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class FileDataReader implements DataReader<Tetrahedron>{

    private static final Logger LOGGER= LogManager.getLogger(FileDataReader.class);

    private final InputValidator inputValidator;
    private final Parser<Tetrahedron> parser;

    public FileDataReader(InputValidator inputValidator, Parser<Tetrahedron> parser) {
        this.inputValidator = inputValidator;
        this.parser = parser;
    }

    @Override
    public Collection<Tetrahedron> getAll() {
        Collection<Tetrahedron> tetrahedronCollection=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(
                new FileReader(
                        new File("data.txt")))){
            String nextLine=bufferedReader.readLine();
            while (nextLine!=null){
                LOGGER.info("Validating input line.");
                if(inputValidator.isValid(nextLine)){
                    LOGGER.info("Line is valid");
                    Tetrahedron tetrahedron=parser.parse(nextLine);
                    tetrahedronCollection.add(tetrahedron);
                }else {
                    LOGGER.warn("Wrong input line\":"+nextLine+"\".");
                }
                nextLine=bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new DataReadException("File not found.",e);
        } catch (IOException e) {
            throw new DataReadException("Error reading file.",e);
        }
        return tetrahedronCollection;
    }
}
