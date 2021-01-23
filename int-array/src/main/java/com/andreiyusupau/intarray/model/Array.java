package com.andreiyusupau.intarray.model;

import java.util.Arrays;

public class Array {

    private int[] numbers;

    public Array() {
    }

    public Array(int[] numbers) {
        this.numbers = numbers;
    }

    public int get(int index) {
        return numbers[index];
    }

    public void set(int index, int newValue) {
        numbers[index] = newValue;
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
        return Arrays.hashCode(numbers);
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

    public int length() {
        return numbers != null ? numbers.length : -1;
    }
}