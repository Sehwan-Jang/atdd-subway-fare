package wooteco.subway.path.domain.farepolicy.distance;

public class Below50Chain implements DistanceExtraFairChain {
    private static final int LIMIT = 50;
    private static final int DELIMITER = 5;
    private static final int EXTRA_FARE_PER_DELIMITER = 100;

    private DistanceExtraFairChain nextChain;

    @Override
    public void setNextChain(DistanceExtraFairChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public int calculateExtraFare(int distance, int beforeChainDistance, int currentFare) {
        if (distance > LIMIT) {
            return nextChain.calculateExtraFare(distance, LIMIT,
                    currentFare + (int) Math.ceil((LIMIT - beforeChainDistance) / DELIMITER) * EXTRA_FARE_PER_DELIMITER);
        }
        return currentFare + (int) Math.ceil((distance - beforeChainDistance) / DELIMITER) * EXTRA_FARE_PER_DELIMITER;
    }
}
