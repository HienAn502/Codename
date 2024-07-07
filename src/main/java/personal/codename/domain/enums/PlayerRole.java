package personal.codename.domain.enums;

public enum PlayerRole {
    SPYMASTER("spymaster"),
    OPERATIVE("operative");
    private String value;

    private PlayerRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
