package com.joshrootdev.calcutip;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML private TextField mealCost;
    @FXML private ComboBox percentageSelect;
    @FXML private Slider peopleSlider;
    @FXML private Label splitLabel;

    @FXML private Label mealPriceText;
    @FXML private Label tipText;
    @FXML private Label totalText;
    @FXML private Label cppText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 101; i++) {
            percentageSelect.getItems().add(String.valueOf(i));
        }

        peopleSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            splitLabel.textProperty().setValue("Split Between " + String.valueOf(newValue.intValue()) + " Individual(s)");
            peopleSlider.setValue(newValue.intValue());
        });

        mealCost.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,6}([\\.]\\d{0,2})?")) {
                mealCost.setText(oldValue);
            }
        });
    }

    public void calculateClicked(Event e) {
        int tipPercent     = Integer.parseInt(String.valueOf(percentageSelect.getValue()));
        int amountOfPeople = (int)Math.round(peopleSlider.getValue());

        double mealCost      = Double.parseDouble(this.mealCost.getText());
        double tipAmount     = (mealCost * ((double)tipPercent / 100));
        double total         = mealCost + tipAmount;
        double costPerPerson = total / amountOfPeople;

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        String mealString  = formatter.format(mealCost);
        String tipString   = formatter.format(tipAmount);
        String totalString = formatter.format(total);
        String cppString   = formatter.format(costPerPerson);

        mealPriceText.setText(mealString);
        tipText.setText(tipString);
        totalText.setText(totalString);
        cppText.setText(cppString);
    }
}
