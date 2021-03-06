package com.andreiyusupau.textparser.model;

public final class Leaf implements Component{

    private final String value;
    private final Type type;

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

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        Leaf leaf = (Leaf) o;

        if (!value.equals(leaf.value)) {return false;}
        return type == leaf.type;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
