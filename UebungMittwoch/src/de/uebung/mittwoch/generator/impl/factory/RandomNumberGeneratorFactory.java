package de.uebung.mittwoch.generator.impl.factory;

import de.uebung.mittwoch.generator.Generator;
import de.uebung.mittwoch.generator.impl.RandomNumberGenerator;

public class RandomNumberGeneratorFactory implements  GeneratorFactory<Integer>{
    @Override
    public Generator<Integer> createInstance() {
        return new RandomNumberGenerator();
    }
}
