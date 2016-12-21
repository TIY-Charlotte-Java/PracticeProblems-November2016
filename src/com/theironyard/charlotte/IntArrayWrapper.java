package com.theironyard.charlotte;

/**
 * Created by Ben on 12/13/16.
 */
public class IntArrayWrapper {
    private Integer[] data;

    public IntArrayWrapper(Integer[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int d : data) {
            sb.append(d);
            sb.append(" ");
        }

        return sb.toString();
    }
}
