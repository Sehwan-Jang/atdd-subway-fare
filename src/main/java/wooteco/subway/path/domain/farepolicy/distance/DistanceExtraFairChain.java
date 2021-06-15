package wooteco.subway.path.domain.farepolicy.distance;

public interface DistanceExtraFairChain {

    void setNextChain(DistanceExtraFairChain policy);

    int calculateExtraFare(int distance, int remaining, int currentFare);
}
