package org.example.exo3;

import java.util.concurrent.Callable;

public class CalculateurCallable implements  Callable<Double> {
    private final int nombre;

    public CalculateurCallable(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public Double call() throws Exception {
        double cube = nombre * nombre * nombre;
        return cube;
    }
}
