package express.search.simulatedannealing.schedule;

public class SimulatedAnnealingSchedule {

    private double initialTemperature;
    private double coolingRate;

    public SimulatedAnnealingSchedule(double initialTemperature, double coolingRate) {
        this.initialTemperature = initialTemperature;
        this.coolingRate = coolingRate;
    }

    public double schedule(int t) {
        return initialTemperature * Math.exp(-coolingRate * t);
    }
}
