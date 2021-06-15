package wooteco.subway.path.domain.farepolicy.distance;

public class Over50Chain implements DistanceExtraFairChain {
    private static final int DELIMITER = 8;
    private static final int EXTRA_FARE_PER_DELIMITER = 100;

    private DistanceExtraFairChain nextChain;

    @Override
    public void setNextChain(DistanceExtraFairChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public int calculateExtraFare(int distance, int beforeChainDistance, int currentFare) {
        return currentFare + (int) Math.ceil((distance - beforeChainDistance) / DELIMITER) * EXTRA_FARE_PER_DELIMITER;
    }
}
