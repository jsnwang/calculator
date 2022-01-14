package com.example.matrixlayout;

import android.os.health.SystemHealthManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> _display = new MutableLiveData<>("0");
    private String display = "";
    private Float numOne;
    private Float numTwo;
    private Float answer;
    private Operators operator;

    public void onePressed(){
        display = display + "1";
        updateDisplay(Float.parseFloat(display));
    }

    public void twoPressed(){
        display = display + "2";
        updateDisplay(Float.parseFloat(display));

    }

    public void threePressed(){
        display = display + "3";
        updateDisplay(Float.parseFloat(display));

    }

    public void fourPressed(){
        display = display + "4";
        updateDisplay(Float.parseFloat(display));

    }

    public void fivePressed(){
        display = display + "5";
        updateDisplay(Float.parseFloat(display));

    }

    public void sixPressed(){
        display = display + "6";
        updateDisplay(Float.parseFloat(display));

    }

    public void sevenPressed(){
        display = display + "7";
        updateDisplay(Float.parseFloat(display));

    }

    public void eightPressed(){
        display = display + "8";
        updateDisplay(Float.parseFloat(display));

    }

    public void ninePressed(){
        display = display + "9";
        updateDisplay(Float.parseFloat(display));

    }

    public void zeroPressed(){
        display = display + "0";
        updateDisplay(Float.parseFloat(display));

    }

    public void dotPressed() {
        if (!display.contains(".")) {
            if(!display.isEmpty()) {
                display = display + ".";
                updateDisplay(Float.valueOf(display));
            }
            else if(display.isEmpty())
            {
                display = display + "0.";
                updateDisplay(Float.parseFloat(display));
            }


        }
    }

    public void plusPressed(){
        operator = Operators.PLUS;
        if (numTwo == null && numOne == null) {
            if(!display.isEmpty()){

                numOne = Float.valueOf(display);
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }

        if(numOne != null) {
            if(!display.isEmpty()){
                numTwo = Float.valueOf(display);
                answer = numOne + numTwo;
                updateDisplay(answer);
                numOne = answer;
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }
    }
    public void minusPressed(){

        operator = Operators.MINUS;
        if (numTwo == null && numOne == null) {
            if(!display.isEmpty()){

                numOne = Float.valueOf(display);
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }

        if(numOne != null){
            if(!display.isEmpty()){
                numTwo = Float.valueOf(display);
                answer = numOne - numTwo;
                updateDisplay(answer);
                numOne = answer;
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }
    }

    public void timesPressed() {
        operator = Operators.TIMES;
        if (numTwo == null && numOne == null) {
            if (!display.isEmpty()) {

                numOne = Float.valueOf(display);
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }

        if (numOne != null) {
            if (!display.isEmpty()) {
                numTwo = Float.valueOf(display);
                answer = numOne * numTwo;
                updateDisplay(answer);
                numOne = answer;
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }
    }

    public void dividePressed() {
        operator = Operators.DIVIDE;
        if (numTwo == null && numOne == null) {
            if (!display.isEmpty()) {

                numOne = Float.valueOf(display);
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }

        if (numOne != null) {
            if (!display.isEmpty()) {
                numTwo = Float.valueOf(display);
                answer = numOne / numTwo;
                updateDisplay(answer);
                numOne = answer;
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }
    }
    public void percentPressed() {
        operator = Operators.PERCENT;

        if (numTwo == null && numOne == null) {
            if (!display.isEmpty()) {

                numOne = Float.valueOf(display);
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }

        if (numOne != null) {
            if (!display.isEmpty()) {
                numTwo = Float.valueOf(display);
                answer = numOne * (numTwo / 100);
                updateDisplay(answer);
                numOne = answer;
                display = "";
                //System.out.println(numOne + ", " + numTwo + ", " + answer);
            }
        }
    }

    public void changeSignPressed(){
        if (!display.isEmpty()) {
                display = _display.getValue();
                numOne = Float.parseFloat(display) * -1;
                updateDisplay(numOne);
            }


    }
    public void calculate(){
        if(!display.isEmpty() && operator != null && !display.equals(".")){
            numTwo = Float.valueOf(display);
            switch (operator) {
                case PLUS:
                    answer = numOne + numTwo;
                    break;
                case MINUS:
                    answer = numOne - numTwo;
                    break;
                case TIMES:
                    answer = numOne * numTwo;
                    break;
                case DIVIDE:
                    answer = numOne / numTwo;
                    break;
                case PERCENT:
                    answer = numOne * (numTwo / 100);
                    break;
            }
            updateDisplay(answer);
            numOne = answer;
            display = "";
            //System.out.println(numOne + ", " + numTwo + ", " + answer);
        }

    }

    private void updateDisplay(Float num){

        if (num % 1.0 != 0)
            _display.setValue(String.format("%s", num));
        else
            _display.setValue(String.format(Locale.ENGLISH,"%.0f", num));
        //_display.setValue(num.toString());
    }

    public void clearDisplay(){
        numOne = null;
        numTwo = null;
        answer = null;
        display = "";
        _display.setValue(display);
    }

    public LiveData<String> getDisplay(){ return _display; }


}
