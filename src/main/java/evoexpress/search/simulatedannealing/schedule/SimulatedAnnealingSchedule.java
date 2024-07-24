package evoexpress.search.simulatedannealing.schedule;

public class SimulatedAnnealingSchedule {

    private int initialTemperature;
    private double coolingRate;

    public SimulatedAnnealingSchedule(int initialTemperature, double coolingRate) {
        this.initialTemperature = initialTemperature;
        this.coolingRate = coolingRate;
    }

    public double schedule(int t) {
        return initialTemperature * Math.exp(-coolingRate * t);
    }
}
