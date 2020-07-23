package backend;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public enum DesignPatterns {

    ADAPTER("Adapter",Categories.ENTKOPPLUNGSMUSTER),
    BEOBACHTER("Beobachter",Categories.ENTKOPPLUNGSMUSTER),
    BRUECKE("Brücke",Categories.ENTKOPPLUNGSMUSTER),
    ITERATOR("Iterator",Categories.ENTKOPPLUNGSMUSTER),
    STELLVERTRETER("Stellvertreter",Categories.ENTKOPPLUNGSMUSTER),
    VERMITTLER("Vermittler",Categories.ENTKOPPLUNGSMUSTER),
    DEKORIERER("Dekorierer",Categories.VARIANTENMUSTER),
    STRATEGIE("Strategie",Categories.VARIANTENMUSTER),
    SCHABLONENMETHODE("Schablonenmethode",Categories.VARIANTENMUSTER),
    FABRIKMETHODE("Fabrikmethode",Categories.VARIANTENMUSTER),
    ABSTRAKE_FABRIK("Abstrakte Fabrik",Categories.VARIANTENMUSTER),
    BESUCHER("Besucher",Categories.VARIANTENMUSTER),
    KOMPOSITUM("Kompositum",Categories.VARIANTENMUSTER),
    EINZELSTUECK("Einzelstück",Categories.ZUSTANDSHANDHABUNGSMUSTER),
    FLIEGENGEWICHT("Fliegengewicht",Categories.ZUSTANDSHANDHABUNGSMUSTER),
    MEMENTO("Memento",Categories.ZUSTANDSHANDHABUNGSMUSTER),
    PROTOTYP("Prototyp",Categories.ZUSTANDSHANDHABUNGSMUSTER),
    ZUSTAND("Zustand",Categories.ZUSTANDSHANDHABUNGSMUSTER),
    BEQUEMLICHKEITSKLASSE("Bequemlichkeits-klasse",Categories.BEQUEMLICHKEITSMUSTER),
    BEQUEMLICHKEITSMETHODE("Bequemlichkeits-methode",Categories.BEQUEMLICHKEITSMUSTER),
    FASSADE("Fassade",Categories.BEQUEMLICHKEITSMUSTER),
    NULLOBJEKT("NullObjekt",Categories.BEQUEMLICHKEITSMUSTER),
    MASTERWORKER("Master-Worker",Categories.STEUERUNGSMUSTER),
    BEFEHL("Befehl",Categories.STEUERUNGSMUSTER);

    public Categories category;
    private String name;
    public ImageIcon image;

    public String getName() {
        return name;
    }

    DesignPatterns(String name, Categories category) {
        this.name = name;
        this.category = category;
        URL url = ClassLoader.getSystemResource("EntwurfsMuster/" + name + ".PNG");
        image = new ImageIcon(url);
    }

}
