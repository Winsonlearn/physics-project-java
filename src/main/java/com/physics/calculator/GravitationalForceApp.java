package com.physics.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class GravitationalForceApp extends Application {

    private TextField tfMass1;
    private TextField tfMass2;
    private TextField tfDistance;
    private Label lblResult;
    private Label lblError;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kalkulator & Informasi Fisika");

        TabPane tabPane = new TabPane();

        Tab calculatorTab = new Tab("Kalkulator Gaya Gravitasi");
        calculatorTab.setClosable(false);
        calculatorTab.setContent(createCalculatorPane());

        Tab informationTab = new Tab("Informasi: Hukum Gravitasi Newton");
        informationTab.setClosable(false);
        informationTab.setContent(createInformationPane());

        tabPane.getTabs().addAll(calculatorTab, informationTab);

        BorderPane rootLayout = new BorderPane();
        rootLayout.setCenter(tabPane);

        Scene scene = new Scene(rootLayout, 550, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createCalculatorPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label sceneTitle = new Label("Hitung Gaya Gravitasi");
        sceneTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox titleBox = new VBox(sceneTitle);
        titleBox.setAlignment(Pos.CENTER);
        grid.add(titleBox, 0, 0, 2, 1);

        Label lblMass1 = new Label("Massa Objek 1 (kg):");
        grid.add(lblMass1, 0, 1);
        tfMass1 = new TextField();
        tfMass1.setPromptText("Contoh: 5.972e24");
        grid.add(tfMass1, 1, 1);

        Label lblMass2 = new Label("Massa Objek 2 (kg):");
        grid.add(lblMass2, 0, 2);
        tfMass2 = new TextField();
        tfMass2.setPromptText("Contoh: 7.348e22");
        grid.add(tfMass2, 1, 2);

        Label lblDistance = new Label("Jarak (meter):");
        grid.add(lblDistance, 0, 3);
        tfDistance = new TextField();
        tfDistance.setPromptText("Contoh: 3.844e8");
        grid.add(tfDistance, 1, 3);

        Button btnCalculate = new Button("Hitung Gaya Gravitasi");
        VBox hbBtn = new VBox(10, btnCalculate);
        hbBtn.setAlignment(Pos.CENTER);
        grid.add(hbBtn, 0, 4, 2, 1);

        lblResult = new Label("Hasil: ");
        lblResult.setStyle("-fx-font-weight: bold;");
        VBox resultBox = new VBox(lblResult);
        resultBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(resultBox, 0, 5, 2, 1);

        lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");
        VBox errorBox = new VBox(lblError);
        errorBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(errorBox, 0, 6, 2, 1);

        btnCalculate.setOnAction(e -> calculateGravitationalForce());
        return grid;
    }

    private ScrollPane createInformationPane() {
        VBox infoVBox = new VBox(15);
        infoVBox.setPadding(new Insets(20));
        infoVBox.setAlignment(Pos.TOP_LEFT);

        Label title = new Label("Hukum Gravitasi Universal Newton");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-underline: true;");

        TextFlow descriptionFlow = new TextFlow();
        Text desc1 = new Text(
                "Hukum gravitasi universal Newton menyatakan bahwa setiap partikel di alam semesta menarik setiap partikel lain dengan gaya yang ");
        Text descBold1 = new Text("sebanding dengan hasil kali massa kedua partikel");
        descBold1.setStyle("-fx-font-weight: bold;");
        Text desc2 = new Text(" dan ");
        Text descBold2 = new Text("berbanding terbalik dengan kuadrat jarak di antara pusat keduanya.");
        descBold2.setStyle("-fx-font-weight: bold;");
        descriptionFlow.getChildren().addAll(desc1, descBold1, desc2, descBold2);
        descriptionFlow.setLineSpacing(5.0);

        Label formulaTitle = new Label("Rumus Gaya Gravitasi (F):");
        formulaTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextFlow formulaFlow = new TextFlow();
        Text f = new Text("F = G \u00D7 "); // Unicode for multiplication sign
        Text m1m2OverR2 = new Text("(m₁ \u00D7 m₂) / r²"); // Unicode for multiplication sign
        m1m2OverR2.setStyle("-fx-font-style: italic;");
        formulaFlow.getChildren().addAll(f, m1m2OverR2);

        Label variablesTitle = new Label("Keterangan:");
        variablesTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        VBox variablesList = new VBox(5);
        variablesList.getChildren().addAll(
                new Text("F = Gaya gravitasi (Newton, N)"),
                new Text("G = Konstanta gravitasi universal (6.67430 \u00D7 10⁻¹¹ N m²/kg²)"),
                new Text("m₁ = Massa objek pertama (kilogram, kg)"),
                new Text("m₂ = Massa objek kedua (kilogram, kg)"),
                new Text("r = Jarak antara pusat kedua massa (meter, m)"));

        Label note = new Label("Catatan: Kalkulator di tab sebelah menggunakan nilai G ini untuk perhitungan.");
        note.setStyle("-fx-font-style: italic; -fx-font-size: 10px;");

        infoVBox.getChildren().addAll(title, descriptionFlow, formulaTitle, formulaFlow, variablesTitle, variablesList,
                note);

        ScrollPane scrollPane = new ScrollPane(infoVBox);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    private void calculateGravitationalForce() {
        lblError.setText("");
        lblResult.setText("Hasil: ");

        try {
            String mass1Str = tfMass1.getText();
            String mass2Str = tfMass2.getText();
            String distanceStr = tfDistance.getText();

            if (mass1Str.isEmpty() || mass2Str.isEmpty() || distanceStr.isEmpty()) {
                lblError.setText("Semua input harus diisi.");
                return;
            }

            mass1Str = mass1Str.replace(',', '.');
            mass2Str = mass2Str.replace(',', '.');
            distanceStr = distanceStr.replace(',', '.');

            double mass1 = Double.parseDouble(mass1Str);
            double mass2 = Double.parseDouble(mass2Str);
            double distance = Double.parseDouble(distanceStr);

            GravitationalForce calculator = new GravitationalForce(mass1, mass2, distance);
            double force = calculator.calculateForce();

            lblResult.setText(String.format("Hasil: %.2e N", force));

        } catch (NumberFormatException ex) {
            lblError.setText("Input tidak valid. Harap masukkan angka yang benar (misal: 5.97e24 atau 123.45).");
        } catch (IllegalArgumentException ex) {
            lblError.setText("Error Kalkulasi: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}