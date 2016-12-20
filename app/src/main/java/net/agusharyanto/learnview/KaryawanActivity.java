package net.agusharyanto.learnview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class KaryawanActivity extends AppCompatActivity {
    private EditText editTextNama;
    private TextView textViewHasil;
    private Spinner spinnerJabatan;
    private RadioGroup radioButtonGroup;
    private Button buttonBaca;
    String[] jabatans = {"Manager","Supervisor","Staff"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karyawan);
        initUI();
        initEvent();

    }

    private void initEvent() {
        buttonBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bacaInput();
            }
        });
    }

    private void initUI() {
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        textViewHasil = (TextView) findViewById(R.id.textViewHasil);
        spinnerJabatan = (Spinner) findViewById(R.id.spinnerJabatan);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroupHobi);
        buttonBaca = (Button) findViewById(R.id.buttonBaca) ;
        isiDataSpinner();
    }

    private void isiDataSpinner() {
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jabatans);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJabatan.setAdapter(adapter);

    }

    private String getHobi(){
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton)  radioButtonGroup.getChildAt(idx);
        String hobi = r.getText().toString();
        Log.d("TAG","hobi:"+hobi);
        return hobi;
    }

    private void bacaInput(){
        String nama = editTextNama.getText().toString();
        String jabatan = spinnerJabatan.getSelectedItem().toString();
        String hasil ="nama : "+nama+"\nJabatan : "+jabatan+"\nHobi : "+getHobi();
        textViewHasil.setText(hasil);

    }


}
