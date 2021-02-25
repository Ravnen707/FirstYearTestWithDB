package sample;
;
import Opskrifter.MadOpskrifter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    public TextField SearchBar;
    public TextArea OpskriftP; // Klasse Variabler
    public TextArea OpskriftB;
    public TextArea OpskriftS;
    public TextField PPersEa;
    public TextField SPersEa;
    public TextField BPersEa;
    public TextField dataSearch;
    public TextField dataopskrift;

    public ArrayList arraypasta() { // Metode Der returner en ArrayList
        ArrayList<MadOpskrifter.Pasta> pastas = new ArrayList<>(); // Arraylist her fra og ned til pastas.add.
        pastas.add(new MadOpskrifter.Pasta(100, "Gram Pasta"));
        pastas.add(new MadOpskrifter.Pasta(25, "Gram Bacon"));
        pastas.add(new MadOpskrifter.Pasta(1, "Tsk Smør"));
        pastas.add(new MadOpskrifter.Pasta(1, "Løg i tern"));
        pastas.add(new MadOpskrifter.Pasta(1, "Æg"));
        pastas.add(new MadOpskrifter.Pasta(13, "Gram Parmesan"));
        pastas.add(new MadOpskrifter.Pasta(13, "Gram Parmesan for tilbehør"));
        return pastas; // returner
    }

    public ArrayList arraysalat() { // Metode Der returner en ArrayList
        ArrayList<MadOpskrifter.Salat> salats = new ArrayList<>(); // Arraylist her fra og ned til pastas.add.
        salats.add(new MadOpskrifter.Salat(63, "Gram blandet salat"));
        salats.add(new MadOpskrifter.Salat(50, "Gram grønne bønner"));
        salats.add(new MadOpskrifter.Salat(50, "Gram sorte oliven"));
        salats.add(new MadOpskrifter.Salat(1, "tun Steak"));
        salats.add(new MadOpskrifter.Salat(2, "Kogte æg"));
        salats.add(new MadOpskrifter.Salat(1, "Rødløg"));
        return salats; // returner
    }

    public ArrayList arraybøf() { // Metode Der returner en ArrayList
        ArrayList<MadOpskrifter.Bøf> bøfs = new ArrayList<>(); // Arraylist her fra og ned til pastas.add.
        bøfs.add(new MadOpskrifter.Bøf(400, " Gram Hakkef Oksekød"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Tsk Smør "));
        bøfs.add(new MadOpskrifter.Bøf(10, " Stilke Frisk Timian"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Stks Løg"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Spsk Worcester Sauce"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Spsk Honning"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Spsk HP-Sauce"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Spsk Rødvinds- eller Balsamicoeddike"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Glas Brun Sovs"));
        bøfs.add(new MadOpskrifter.Bøf(1, " Stks Stribet Bede"));
        bøfs.add(new MadOpskrifter.Bøf(4, " Drue Argurker"));
        return bøfs; // returner
    }

    public void buttonOnAction() throws IOException { //metode første button i KogebogGUI.fxml.
        String search = SearchBar.getText(); // text fra textfield.
        int numbers = Integer.parseInt(search); // lavet om til en "int".
        switch (numbers) { // Start på Switch.
            case 1:
                System.out.println("Pasta Carbonara"); // Viser det i Terminalen.
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/PastaCabonaraGUI.fxml")); // kalder efter rigtige GUI.
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show(); // Laver en ny Scene.
                break;
            case 2:
                System.out.println("Bøf med løg");
                Parent root1 = FXMLLoader.load(getClass().getResource("../GUI/BøfMedLøg.fxml"));
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
                break;
            case 3:
                System.out.println("Salat med Tun");
                Parent root2 = FXMLLoader.load(getClass().getResource("../GUI/SalatMedTun.fxml"));
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root2));
                stage2.show();
                break;
            case 4:
                System.out.println("All in one");
                Parent root3 = FXMLLoader.load(getClass().getResource("../GUI/DataRecipes.fxml"));
                Stage stage3 = new Stage();
                stage3.setScene(new Scene(root3));
                stage3.show();
                break;

        }
    }

    public void searchbarOnAction() { // metode SeachBar for KogebogGUI.fxml
        System.out.println("Enter"); // for terminalen
        SearchBar.setOnKeyPressed(new EventHandler<KeyEvent>() { //Key Handler. Der gør at den kan reagere med "Enter" når trykket på.
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    try { // Try/Catch til fejl håndtering.
                        buttonOnAction();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void PPersEach() { // metode for Pasta Scene for TextArea
        ArrayList<MadOpskrifter.Pasta> pasto = arraypasta(); // Arraylist der kalder efter "arraypasta return"
        String search = PPersEa.getText(); // String der gør det muligt at bruge ord.
        int antal = Integer.parseInt(search); // int der gør det muligt at bruge tal.
        PPersEa.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    OpskriftP.clear();
                    int total = 0;
                    for (MadOpskrifter.Pasta p : pasto) {
                        total += p.tal;
                        System.out.println(p.tal + " " + p.ord);
                        OpskriftP.appendText(p.tal * antal + " " + p.ord + "\n");
                    }
                }
            }
        });
        System.out.println("___________________________________________________");
        System.out.println("Mad for hvor mange mennesker?");
        System.out.println(antal);
        System.out.println("Enter");
// De her 4 linjer skriver det ned i Terminalen.
    }

    public void BPersEach() {
        ArrayList<MadOpskrifter.Bøf> bøfo = arraybøf(); // Arraylist der kalder efter "arraybøf return"
        String search = BPersEa.getText(); // String der gør det muligt at bruge ord.
        int antal = Integer.parseInt(search); // int der gør det muligt at bruge tal.
        BPersEa.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    OpskriftB.clear();
                    int total = 0;
                    for (MadOpskrifter.Bøf b : bøfo) {
                        total += b.tal;
                        System.out.println(b.tal + " " + b.ord);
                        OpskriftB.appendText(b.tal * antal + " " + b.ord + "\n");
                    }
                }
            }
        });
        System.out.println("___________________________________________________");
        System.out.println("Mad for hvor mange mennesker?");
        System.out.println(antal);
        System.out.println("Enter");
// De her 4 linjer skriver det ned i Terminalen.
    }

    public void SPersEach() {
        ArrayList<MadOpskrifter.Salat> salato = arraysalat(); // Arraylist der kalder efter "arraysalat return"
        String search = SPersEa.getText(); // String der gør det muligt at bruge ord.
        int antal = Integer.parseInt(search); // int der gør det muligt at bruge tal.
        SPersEa.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    OpskriftS.clear();
                    int total = 0;
                    for (MadOpskrifter.Salat s : salato) {
                        total += s.tal;
                        System.out.println(s.tal + " " + s.ord);
                        OpskriftS.appendText(s.tal * antal + " " + s.ord + "\n");
                    }
                }
            }
        });
        System.out.println("___________________________________________________");
        System.out.println("Mad for hvor mange mennesker?");
        System.out.println(antal);
        System.out.println("Enter");
// De her 4 linjer skriver det ned i Terminalen.
    }

}

