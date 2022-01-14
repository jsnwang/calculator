package com.example.matrixlayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.matrixlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        initViews();
        initObservers();

    }

    private void initViews(){
        binding.keypad.btnOne.setOnClickListener(view -> {
            viewModel.onePressed();
        });

        binding.keypad.btnTwo.setOnClickListener(view -> {
            viewModel.twoPressed();
        });

        binding.keypad.btnThree.setOnClickListener(view -> {
            viewModel.threePressed();
        });

        binding.keypad.btnFour.setOnClickListener(view -> {
            viewModel.fourPressed();
        });

        binding.keypad.btnFive.setOnClickListener(view -> {
            viewModel.fivePressed();
        });

        binding.keypad.btnSix.setOnClickListener(view -> {
            viewModel.sixPressed();
        });

        binding.keypad.btnSeven.setOnClickListener(view -> {
            viewModel.sevenPressed();
        });

        binding.keypad.btnEight.setOnClickListener(view -> {
            viewModel.eightPressed();
        });

        binding.keypad.btnNine.setOnClickListener(view -> {
            viewModel.ninePressed();
        });

        binding.keypad.btnZero.setOnClickListener(view -> {
            viewModel.zeroPressed();
        });

        binding.keypad.btnDot.setOnClickListener(view -> {
            viewModel.dotPressed();
        });

        binding.keypad.btnPlus.setOnClickListener(view -> {
            viewModel.plusPressed();
        });

        binding.keypad.btnMinus.setOnClickListener(view -> {
            viewModel.minusPressed();
        });

        binding.keypad.btnTimes.setOnClickListener(view -> {
            viewModel.timesPressed();
        });

        binding.keypad.btnDivide.setOnClickListener(view -> {
            viewModel.dividePressed();
        });

        binding.keypad.btnC.setOnClickListener(view -> {
            viewModel.clearDisplay();
        });

        binding.keypad.btnChangeSign.setOnClickListener(view -> {
            viewModel.changeSignPressed();
        });

        binding.keypad.btnEquals.setOnClickListener(view -> {
            viewModel.calculate();
        });
        binding.keypad.btnPercent.setOnClickListener(view -> {
            viewModel.percentPressed();
        });
    }

    private void initObservers(){
        viewModel.getDisplay().observe(this, display -> {
            binding.textBox.setText(display);
        });
    }
}