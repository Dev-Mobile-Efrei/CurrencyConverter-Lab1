package fr.android.eurodollar;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = findViewById(R.id.editText1);
    }

    public void myClickHandler(@NotNull View view) {
        if (view.getId() == R.id.btnConvert) {
            RadioButton euroButton = findViewById(R.id.radioEuro);
            RadioButton dollarButton = findViewById(R.id.radioDollar);

            if (editText.getText().length() == 0) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                return;
            }

            float inputValue = Float.parseFloat(editText.getText().toString());
            if (euroButton.isChecked()) {
                editText.setText(String
                        .valueOf(convertDollarToEuro(inputValue)));
                euroButton.setChecked(false);
                dollarButton.setChecked(true);
            } else {
                editText.setText(String
                        .valueOf(convertEuroToDollar(inputValue)));
                dollarButton.setChecked(false);
                euroButton.setChecked(true);
            }
        }
    }

    private float convertDollarToEuro(float dollar) {
        return dollar / 1.09f;
    }

    private float convertEuroToDollar(float euro) {
        return euro * 1.09f;
    }
}