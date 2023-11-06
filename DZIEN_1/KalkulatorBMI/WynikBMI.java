package com.marcin.kalkulatorbmi;

public class WynikBMI implements ILiczenieBMI{
    double m;
    double w;

    public WynikBMI(double m, double w) {
        this.m = m;
        this.w = w;
    }

    @Override
    public double obliczBMI(double m, double w) {
        return m/Math.pow(w/100,faktor);
    }
}
