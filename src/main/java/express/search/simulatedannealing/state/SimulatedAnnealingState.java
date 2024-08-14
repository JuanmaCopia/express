package express.search.simulatedannealing.state;


public interface SimulatedAnnealingState {
    
    double getFitness();

    void setFitness(double fitness);

    SimulatedAnnealingState clone();
}
