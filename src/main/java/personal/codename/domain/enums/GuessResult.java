package personal.codename.domain.enums;

public enum GuessResult {
    CORRECT(true),
    WRONG(false);

    private boolean value;

    private GuessResult(boolean value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return value;
    }
}
