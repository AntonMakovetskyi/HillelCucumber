package enums;

public enum WebElementStates {
    DISPLAYED(true),
    NOT_DISPLAYED(false);

    private boolean value;

    public boolean getValue() {
        return value;
    }

    WebElementStates(boolean value) {
        this.value = value;
    }
}
