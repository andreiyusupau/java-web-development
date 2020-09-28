package com.andreiyusupau.intarray.model;


public class Array {

    private int[] numbers;

    public Array() {
    }

    public Array(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getNumber(int index){
        if(index<numbers.length){
            return numbers[index];
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void setNumber(int index, int newValue){
        if(index<numbers.length){
            numbers[index]=newValue;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Array array = (Array) o;
        int[] thisNumbers = this.numbers;
        int[] otherNumbers = array.numbers;
        if (thisNumbers.length != otherNumbers.length) {
            return false;
        }
        for (int i = 0; i < thisNumbers.length; i++) {
            if (thisNumbers[i] != otherNumbers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result=1;
        for(int i=0;i<this.numbers.length;i++){
            result+=(i+1)*this.numbers[i]+31;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("numbers=");
        if (numbers == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < numbers.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(numbers[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
