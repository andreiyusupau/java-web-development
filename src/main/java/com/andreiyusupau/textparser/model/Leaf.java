package com.andreiyusupau.textparser.model;

public final class Leaf implements Component{

    private final String value;
    private final Type type;

    @Override
    public void operation() {

    }

    enum Type {EXPRESSION,WORD}

    private Leaf(String value,Type type){
        this.value=value;
        this.type=type;
    }

    public static Leaf newExpression(String value){
        return new Leaf(value, Type.EXPRESSION);
    }

    public static Leaf newWord(String value){
        return new Leaf(value, Type.WORD);
    }

    @Override
    public String toString() {
        return "Leaf{" + value + '}';
    }
}
