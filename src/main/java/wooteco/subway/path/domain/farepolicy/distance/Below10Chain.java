package wooteco.subway.path.domain.farepolicy.distance;

public class Below10Chain implements DistanceExtraFairChain {
    private static final int LIMIT = 10;
    private static final int DELIMITER = 1;
    private static final int EXTRA_FARE_PER_DELIMITER = 0;

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
