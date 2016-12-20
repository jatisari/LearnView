package net.agusharyanto.learnview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNama;
    private TextView textViewHelloWorld, textViewHasil;
    private Button buttonBaca;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNama = (EditText) findViewById(R.id.editTextNama);
        textViewHelloWorld = (TextView) findViewById(R.id.textView);
        textViewHasil = (TextView) findViewById(R.id.textViewHasil);

        // edtNama.setEnabled(false);
        buttonBaca = (Button) findViewById(R.id.buttonBaca);
        buttonBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bacaInput();
            }
        });

        initSpinner();
    }


    private void initSpinner(){
        spinner = (Spinner) findViewById(R.id.spinnerCourse);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.courses_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void bacaInput() {
        String course = spinner.getSelectedItem().toString();
        String isitv = textViewHelloWorld.getText().toString();
        String nama = edtNama.getText().toString();
        String hasil = isitv+" "+nama+"\ncourse:"+course;
        Toast.makeText(getBaseContext(),hasil, Toast.LENGTH_SHORT).show();
        textViewHasil.setText(hasil);
    }
}
