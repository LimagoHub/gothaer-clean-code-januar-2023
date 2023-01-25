package de.uebung.mittwoch.generator.impl.factory;

import de.uebung.mittwoch.generator.Generator;

public interface GeneratorFactory<T> {

    public Generator<T> createInstance() ;
}
