package backend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
        try {
            BufferedImage img = ImageIO.read(url);
            img = resize(img, img.getWidth()/3,img.getHeight()/3);
            image = new ImageIcon(img);
        } catch (IOException ignored) {
        }
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}
