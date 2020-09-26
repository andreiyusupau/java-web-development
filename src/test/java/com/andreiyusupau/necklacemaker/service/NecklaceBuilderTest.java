package com.andreiyusupau.necklacemaker.service;

import com.andreiyusupau.necklacemaker.model.Gem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NecklaceBuilderTest {

    @Test
    void shouldAddNewGem(){
        NecklaceBuilder necklaceBuilder= new NecklaceBuilder();
        necklaceBuilder.addGem(new Gem(Gem.GemType.RUBY,2,new BigDecimal(250)));
        int sizeAfterGemAdd=necklaceBuilder.build()
                .getGems()
                .size();
        Assertions.assertEquals(1,sizeAfterGemAdd);
    }
}
