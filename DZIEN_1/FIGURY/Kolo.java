package com.marcin.figury;

public class Kolo extends Figura {
    public Kolo(double a) {
        super(a);
    }

    @Override
    public double policzPole() {
        return Math.PI*a*a;
    }
}
