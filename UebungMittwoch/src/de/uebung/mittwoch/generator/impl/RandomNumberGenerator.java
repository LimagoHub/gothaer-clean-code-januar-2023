package de.uebung.mittwoch.generator.impl;

import de.uebung.mittwoch.generator.Generator;

import java.util.Random;

public class RandomNumberGenerator implements Generator<Integer> {

    Random random = new Random();
    @Override
    public Integer nextValue() {
        return random.nextInt();
    }
}
