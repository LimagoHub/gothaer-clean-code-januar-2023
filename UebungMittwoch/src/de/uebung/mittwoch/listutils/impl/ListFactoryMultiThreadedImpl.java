package de.uebung.mittwoch.listutils.impl;

import de.uebung.mittwoch.listutils.ListFactory;
import de.uebung.mittwoch.generator.Generator;
import de.uebung.mittwoch.generator.impl.factory.GeneratorFactory;

import java.util.ArrayList;
import java.util.List;

public class ListFactoryMultiThreadedImpl<T> implements ListFactory<T> {

    private final GeneratorFactory<T> generatorFactory;
    private final int numberOfThreads;

    public ListFactoryMultiThreadedImpl(GeneratorFactory<T> generatorFactory, int numberOfThreads) {
        this.generatorFactory = generatorFactory;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public List<T> createFilledList(int size) {
        ArrayList<T> result = new ArrayList<>(size);


        Generator<T> generator = generatorFactory.createInstance();
        for(int i = 0; i < 10; i ++)
            result.add(generator.nextValue());
        return  result;
    }

}
