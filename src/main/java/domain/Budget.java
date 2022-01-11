package domain;

public class Budget {

    private int money;

    public void setMoney(int money) {

        checkMoney(money);
        this.money = money;
    }

    public int calcTotalLottoCount(int price) {
        return (int)(money/price);
    }

    private void checkMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액은 양수여야 합니다.");
        }
    }
}
