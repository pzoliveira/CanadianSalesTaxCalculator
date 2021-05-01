package com.example.canadiantaxsalescalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Declare
    Spinner spinnerProvinceList;
    Province provinceSelected;
    TextView tvInitialCost;
    TextView tvTotalCost;
    SeekBar sbInitialCost;
    int initialCost;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        spinnerProvinceList = (Spinner) findViewById(R.id.spinnerProvinceList);
        tvInitialCost = (TextView) findViewById(R.id.tvInitialCost);
        tvTotalCost = (TextView) findViewById(R.id.tvTotalCost);
        sbInitialCost = (SeekBar) findViewById(R.id.sbInitialCost);
        initialCost = 0;
        provinceSelected = Province.Alberta;

        ArrayAdapter<Province> adapter = new ArrayAdapter<>(this, R.layout.spinner_layout, Province.values());
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinnerProvinceList.setAdapter(adapter);
        spinnerProvinceList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provinceSelected = (Province) parent.getItemAtPosition(position);
                displayTotalCost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       sbInitialCost.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                initialCost = progress;
                tvInitialCost.setText("Initial Cost: $" + initialCost);
                displayTotalCost();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void displayTotalCost() {
        totalCost = (1 + provinceSelected.getTaxPercentage()) * initialCost;
        String totalCostMessage = String.format(Locale.getDefault(), "Total Cost: $%.2f", totalCost);
        tvTotalCost.setText(totalCostMessage);
    }
}