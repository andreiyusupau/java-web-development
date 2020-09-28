package com.andreiyusupau.intarray.dao;


import com.andreiyusupau.intarray.model.Array;
import com.andreiyusupau.intarray.util.ArrayConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileArrayDAO implements DAO<Array> {

    private static final String NUMBER_REGEX="-?\\d{1,9}";
    private static final String FILEPATH="numbers.data";

    @Override
    public Array get() {
        File file = new File(FILEPATH);
        List<Integer> list=new ArrayList<>();
        if (file.exists() && file.length() != 0) {
            try( BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String nextLine;
                while ((nextLine = bufferedReader.readLine()) != null) {
                    if(nextLine.matches(NUMBER_REGEX)){
                        list.add(Integer.valueOf(nextLine));
                    }else {
                        throw new NumberFormatException();
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("File with numbers not found.");
            } catch (IOException e) {
                System.err.println("Error reading file with numbers.");
            }
        }
        return new Array(ArrayConverter.toPrimitive(list));
    }


}
