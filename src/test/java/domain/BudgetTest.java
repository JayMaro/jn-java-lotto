package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BudgetTest {

    private final Budget budget = new Budget();

    @ParameterizedTest
    @DisplayName("로또 갯수 반환 테스트")
    @ValueSource(ints = {900, 1000, 14000, 13500})
    void calcTotalLottoCountTest(int money) {
        budget.setMoney(money);
        int count = budget.calcTotalLottoCount(LottoPrice.getPrice());
        Assertions.assertThat(count).isEqualTo((int)(money/LottoPrice.getPrice()));
    }

    @ParameterizedTest
    @DisplayName("구매 금액 저장 테스트")
    @ValueSource(ints = {-1000, 0, -1})
    void saveBudgetTest(int money) {
        Assertions.assertThatThrownBy(() -> {
            budget.setMoney(money);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("금액은 양수여야 합니다.");
    }
}
