package domain;

public class LottoNumber {

    private int number;

    public void setNumber(int number) {
        checkValidation(number);
        this.number = number;
    }

    private void checkValidation(int number) {
        if (number <= 0 || number >= 45) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하 입니다.");
        }
    }

}
