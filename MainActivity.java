package com.example.myapplication;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText edtabsen, edttugas, edtuts, edtuas;
    private Button btnHitung;
    private TextView txtnilai;
    private TextView txtgrade;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("NILAI MAHASISWA");


        edtabsen = (EditText) findViewById(R.id.nilaiabsen);
        edttugas = (EditText) findViewById(R.id.nilaitugas);
        edtuts = (EditText) findViewById(R.id.nilaiuts);
        edtuas = (EditText) findViewById(R.id.nilaiuas);
        btnHitung = (Button) findViewById(R.id.tombol);
        txtnilai = (TextView) findViewById(R.id.nilaiakhir);
        txtgrade = (TextView) findViewById(R.id.nilaigrade);
        txtketerangan = (TextView) findViewById(R.id.nilaiketerangan);

        btnHitung.setOnClickListener(new View.OnClickListener() { @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            TextView matkulTextView = findViewById(R.id.tampil_matkul);
            Spinner spinnerPilihMatkul = findViewById(R.id.listmatakuliah);
            String mataKuliah =
        String.valueOf(spinnerPilihMatkul.getSelectedItem());
            String absen = edtabsen.getText().toString().trim();
            String tugas = edttugas.getText().toString().trim();
            String uts = edtuts.getText().toString().trim();
            String uas = edtuas.getText().toString().trim();

            matkulTextView.setText("Matkul : " + mataKuliah);


            double a = Double.parseDouble(absen);
            double t = Double.parseDouble(tugas);
            double u = Double.parseDouble(uts);
            double ua = Double.parseDouble(uas);
            double nilai = (0.0012 * a) + (0.0024 * t) + (0.25 * u) + (0.39 * ua);
                    txtnilai.setText("Nilai:" + nilai);

            if (nilai >= 85) {
                txtgrade.setText("Grade A");
            } else if (nilai >= 80) {
                txtgrade.setText("Grade AB");
            } else if (nilai >= 75) {
                txtgrade.setText("Grade B");
            } else if (nilai >= 60) {
                txtgrade.setText("Grade C");
            } else if (nilai >= 50) {
                txtgrade.setText("Grade D");
            } else {
                txtgrade.setText("Grade E");

            }
            if (nilai >=60){
                txtketerangan.setText("Keterangan :LULUS");
            }else {
                txtketerangan.setText("Keterangan :TIDAK LULUS");
            }

        }
        });
    }
}

