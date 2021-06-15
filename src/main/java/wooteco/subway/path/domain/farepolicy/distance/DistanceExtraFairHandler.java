package wooteco.subway.path.domain.farepolicy.distance;

public class DistanceExtraFairHandler {

    public static final int DEFAULT_LIMIT = 0;
    public static final int DEFAULT_EXTRA_FARE = 0;

    private final DistanceExtraFairChain initialChain = new Below10Chain();

    public DistanceExtraFairHandler() {
        DistanceExtraFairChain below50 = new Below50Chain();
        DistanceExtraFairChain finalChain = new Over50Chain();

        initialChain.setNextChain(below50);
        below50.setNextChain(finalChain);
    }

    public int calculateExtraFare(int distance) {
        return initialChain.calculateExtraFare(distance, DEFAULT_LIMIT, DEFAULT_EXTRA_FARE);
    }
}
