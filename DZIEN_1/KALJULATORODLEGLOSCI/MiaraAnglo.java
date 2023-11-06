package com.marcin.kalkulatorodleglosci;

public abstract class MiaraAnglo {
    protected double odl;

    public MiaraAnglo(double odl) {
        this.odl = odl;
    }
    
    public abstract double policzOdl();
}
