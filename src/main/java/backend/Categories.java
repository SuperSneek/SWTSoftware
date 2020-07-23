package backend;

public enum Categories {
    VARIANTENMUSTER("Variantenmuster"), ENTKOPPLUNGSMUSTER("Entkopplungsmuster"),
    ZUSTANDSHANDHABUNGSMUSTER("Zustandshandhabungsmuster"), BEQUEMLICHKEITSMUSTER("Bequemlichkeitsmuster"),
    STEUERUNGSMUSTER("Steuerungsmuster");

    public String name;

    Categories(String name) {
        this.name = name;
    }
}
