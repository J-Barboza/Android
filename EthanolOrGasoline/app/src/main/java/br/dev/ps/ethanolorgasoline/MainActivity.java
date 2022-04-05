package br.dev.ps.ethanolorgasoline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textGas;
    private TextInputEditText textEthanol;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGas     = findViewById(R.id.textGas);
        textEthanol = findViewById(R.id.textEthanol);
        textResult  = findViewById(R.id.textViewResult);
    }

    public void calculateWhatsBetter(View view){

        String txtValueGas = Objects.requireNonNull(textGas.getText()).toString();
        String txtValueAlcohol = Objects.requireNonNull(textEthanol.getText()).toString();

        if (validFields(txtValueGas, txtValueAlcohol)) {
            double valueGas = Double.parseDouble(txtValueGas);
            double valueEthanol = Double.parseDouble(txtValueAlcohol);
            if ((valueGas * 0.7) <= valueEthanol) {
                textResult.setText(R.string.textResultGas);
            } else {
                textResult.setText(R.string.textResultEthanol);
            }
        } else {
            textResult.setText(R.string.textInformation);
        }
    }

    public Boolean validFields(String pAlcohol, String pGas) {
        boolean fieldsValid = true;
        if (pAlcohol == null || pAlcohol.equals("") ||
                pGas == null || pGas.equals("")) {
            fieldsValid = false;
        }
        return fieldsValid;
    }
}