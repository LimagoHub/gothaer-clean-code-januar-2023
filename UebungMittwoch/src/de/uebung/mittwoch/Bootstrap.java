package de.uebung.mittwoch;

import de.uebung.mittwoch.generator.impl.factory.GeneratorFactory;
import de.uebung.mittwoch.listutils.ListFactory;
import de.uebung.mittwoch.listutils.impl.ListFactoryMultiThreadedImpl;
import de.uebung.mittwoch.client.ListClient;
import de.uebung.mittwoch.generator.impl.factory.RandomNumberGeneratorFactory;

public class Bootstrap {

    public void start() {
        for (int numberOfThreads = 1; numberOfThreads < Runtime.getRuntime().availableProcessors() + 1; numberOfThreads++) {
            startCreateAndFillArray(numberOfThreads);
        }
    }

    private static void startCreateAndFillArray(int numberOfThreads) {
        GeneratorFactory<Integer> generatorFactory = new RandomNumberGeneratorFactory();

        ListFactory<Integer> factory = new ListFactoryMultiThreadedImpl<>(generatorFactory, numberOfThreads);

        factory = (ListFactory<Integer>)  TimeMeasurementProxy.newInstance(factory);

        System.out.println("Messung mit " + numberOfThreads + " Threads");
        var gefuellteListe = factory.createFilledList(10);


        var client = new ListClient<Integer>(gefuellteListe);
    }
}
