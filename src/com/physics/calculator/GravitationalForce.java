package com.physics.calculator;

public class GravitationalForce {
    private static final double G = 6.67430e-11;

    private double mass1;
    private double mass2;
    private double distance;

    public GravitationalForce(double mass1, double mass2, double distance) {
        if (mass1 <= 0 || mass2 <= 0) {
            throw new IllegalArgumentException("Massa harus lebih besar dari nol.");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Jarak harus lebih besar dari nol.");
        }
        this.mass1 = mass1;
        this.mass2 = mass2;
        this.distance = distance;
    }

    public double getMass1() {
        return mass1;
    }

    public void setMass1(double mass1) {
        if (mass1 <= 0) {
            throw new IllegalArgumentException("Massa harus lebih besar dari nol.");
        }
        this.mass1 = mass1;
    }

    public double getMass2() {
        return mass2;
    }

    public void setMass2(double mass2) {
        if (mass2 <= 0) {
            throw new IllegalArgumentException("Massa harus lebih besar dari nol.");
        }
        this.mass2 = mass2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Jarak harus lebih besar dari nol.");
        }
        this.distance = distance;
    }

    public double calculateForce() {
        return G * (mass1 * mass2) / (distance * distance);
    }

    @Override
    public String toString() {
        return "GravitationalForceCalculator{" +
               "mass1=" + mass1 + " kg" +
               ", mass2=" + mass2 + " kg" +
               ", distance=" + distance + " m" +
               '}';
    }
} 