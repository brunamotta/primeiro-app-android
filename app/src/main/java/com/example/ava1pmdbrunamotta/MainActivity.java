package com.example.ava1pmdbrunamotta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView titulo;
    TextView labelA1;
    TextView labelA2;
    TextView labelA3;
    TextView resultado;
    TextView notaFinal;
    TextView resultadoFinal;
    EditText inputA1, inputA2, inputA3;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titulo = findViewById(R.id.titulo);
        titulo.setText("Calculadora de Média UVA");

        labelA1 = findViewById(R.id.labelA1);
        labelA1.setText("Nota da A1");

        inputA1 = findViewById(R.id.inputNotaA1);

        labelA2 = findViewById(R.id.labelA2);
        labelA2.setText("Nota da A2");

        inputA2 = findViewById(R.id.inputNotaA2);

        labelA3 = findViewById(R.id.labelA3);
        labelA3.setText("Nota da A3");

        inputA3 = findViewById(R.id.inputNotaA3);

        resultado = findViewById(R.id.resultado);
        resultado.setText("");

        notaFinal = findViewById(R.id.notaFinal);
        notaFinal.setText("");

        resultadoFinal = findViewById(R.id.resultadoFinal);
        resultadoFinal.setText("");

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setText("Calcular");
    }

    public void calcularMedia(View view) {
        double notaA1;
        double notaA2;
        double notaA3;
        double mediaPonderada;
        double notaMaior;

        if (inputA1.getText().toString().isEmpty()) {
            notaA1 = 0;
        } else {
            notaA1 = Double.parseDouble(inputA1.getText().toString());
        }

        if (inputA2.getText().toString().isEmpty()) {
            notaA2 = 0;
        } else {
            notaA2 = Double.parseDouble(inputA2.getText().toString());
        }

        if (inputA3.getText().toString().isEmpty()) {
            notaA3 = 0;
        } else {
            notaA3 = Double.parseDouble(inputA3.getText().toString());
        }

        notaMaior = Math.max(notaA2, notaA3);
        resultado.setText("Sua nota final é:");

        if(notaA1 == 0) {
            mediaPonderada = (notaA1*0.4 + notaMaior*0.6)/2;
            notaFinal.setText(String.valueOf(mediaPonderada));
            resultadoFinal.setText("Você foi reprovado, pois tirou zero na A1.");
        } else {
            mediaPonderada = (notaA1 * 0.4) + (notaMaior * 0.6);
            if (mediaPonderada >= 6) {
                notaFinal.setText(String.valueOf(mediaPonderada));
                resultadoFinal.setText("Parabéns você foi aprovado!");
            } else {
                notaFinal.setText(String.valueOf(mediaPonderada));
                resultadoFinal.setText("Você foi reprovado pois sua média é menor que 6.");
            }
        }
    }
}