package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    private LottoNumber lottoNumber = new LottoNumber();

    @ParameterizedTest
    @DisplayName("로또 숫자 유효성 테스트")
    @ValueSource(ints = {-1, 0, 56, 1000})
    public void lottoNumberValidationTest(int number) {
        Assertions.assertThatThrownBy(() -> {
                lottoNumber.setNumber(number);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 숫자는 1 이상 45 이하 입니다.");
    }
}
