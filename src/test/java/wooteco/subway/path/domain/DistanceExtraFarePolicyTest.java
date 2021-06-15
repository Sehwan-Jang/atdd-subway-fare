package wooteco.subway.path.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import wooteco.subway.path.domain.farepolicy.distance.DistanceExtraFairHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceExtraFarePolicyTest {

    @ParameterizedTest(name = "거리 추가 요금 계산 테스트")
    @CsvSource(value = {"10:0", "50:800", "90:1300"}, delimiter = ':')
    void apply(int distance, int expected) {
        DistanceExtraFairHandler handler = new DistanceExtraFairHandler();

        // when
        final int extraFare = handler.calculateExtraFare(distance);

        // then
        assertThat(extraFare).isEqualTo(expected);
    }
}
