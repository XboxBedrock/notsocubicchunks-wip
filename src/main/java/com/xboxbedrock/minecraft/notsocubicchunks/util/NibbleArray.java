package com.xboxbedrock.minecraft.notsocubicchunks.util;


import lombok.Getter;

import java.util.Arrays;

//My Extremely bad take on a nibble array
//In theory this is just a very simple implementation of just combing two nibbles into a byte
public class NibbleArray {


    @Getter
    private final byte[] storedBytes;

    //The size is the amount of nibbles you can store
    public NibbleArray(int size, byte fillValue) {

        if (size < 0) throw new IllegalArgumentException("Size cannot be negative");
        if (size % 2 != 0) throw new IllegalArgumentException("Size must be even");

        storedBytes = new byte[size/2];

        fill(fillValue);
    }

    public NibbleArray(byte... byteData) {
        storedBytes = byteData;
    }


    public void set(int index, byte value) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be negative");
        if (index > storedBytes.length) throw new IllegalArgumentException("Index out of bounds");

        value &= 0x1111; //standard making sure its a nibble

        int trueIdx = index/2;

        byte currentByte = storedBytes[trueIdx];

        if (index % 2 == 0) {
            storedBytes[trueIdx] = (byte) ((currentByte & 0b11110000) | value);
        } else {
            storedBytes[trueIdx] = (byte) ((currentByte & 0b00001111) | value << 4);
        }
    }


    public void fill(byte toFill) {
        toFill &= 0x1111; //just  to make sure its a nibble
        //Just duplicate the value twice per byte
        Arrays.fill(storedBytes, (byte) (toFill | toFill << 4));
    }

    public byte get(int index) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be negative");
        int trueIdx = index/2;
        byte currentByte = storedBytes[trueIdx];
        if (index % 2 == 0) {
            return (byte) (currentByte & 0b00001111);
        } else {
            return (byte) ((currentByte & 0b11110000) >> 4);
        }
    }

    public void copyRawData(byte... copyFrom) {
        if (copyFrom.length != storedBytes.length) throw new IllegalArgumentException("Copy length must be equal to stored length");

        //Intellisense just filled in this whole line, it is clearly getting good :skull:
        System.arraycopy(copyFrom, 0, storedBytes, 0, copyFrom.length);
    }

    public int length() {
        return storedBytes.length*2;
    }

    public int byteLength() {
        return storedBytes.length;
    }


    public NibbleArray frozenClone() {
        //create a frozen clone of the Nibble Array
        return new NibbleArray(storedBytes.clone());
    }

}
