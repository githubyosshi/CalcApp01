package com.bird_brown.calcapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView display;
    private Button[] buttons;
    private Calc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //アプリ起動時に呼びだされるメソッド
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView)findViewById(R.id.display);     //数字表示部のTextViewのオブジェクト取得
        buttons = new Button[17];

        //それぞれのButtonのオブジェクトを取得しイベントリスナー登録を行う
        int[] buttonId = {
                R.id.zero_button, R.id.one_button, R.id.two_button,
                R.id.three_button, R.id.four_button, R.id.five_button,
                R.id.six_button, R.id.seven_button, R.id.eight_button,
                R.id.nine_button, R.id.ac_button, R.id.mul_button,
                R.id.div_button, R.id.plus_button, R.id.minus_button,
                R.id.dot_button, R.id.equal_button
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button)findViewById(buttonId[i]);
            buttons[i].setOnClickListener(this);
        }

        //数字表示部のTextViewに初期値0を表示する
        calc = new Calc("0","0");
        display.setText(calc.clear());
    }


    @Override
    public void onClick(View view) {    //ボタンが押された時に呼び出されるonClickメソッド
        int id = view.getId();

        //数字が押されたらその数字を数字表示部のTextViewに表示する
        switch (id) {
            case R.id.zero_button :
                display.setText(calc.inputData("0"));
                break;
            case R.id.one_button :
                display.setText(calc.inputData("1"));
                break;
            case R.id.two_button :
                display.setText(calc.inputData("2"));
                break;
            case R.id.three_button :
                display.setText(calc.inputData("3"));
                break;
            case R.id.four_button :
                display.setText(calc.inputData("4"));
                break;
            case R.id.five_button :
                display.setText(calc.inputData("5"));
                break;
            case R.id.six_button :
                display.setText(calc.inputData("6"));
                break;
            case R.id.seven_button :
                display.setText(calc.inputData("7"));
                break;
            case R.id.eight_button :
                display.setText(calc.inputData("8"));
                break;
            case R.id.nine_button :
                display.setText(calc.inputData("9"));
                break;
            case R.id.ac_button :       //ACボタンを押されたら０を表示
                display.setText(calc.clear());
                break;
            case R.id.mul_button :      //掛け算準備を行う
                calc.onOperatorButtonClick(1);
                //display.setText(calc.doCalc("*"));
                break;
            case R.id.div_button :      //割り算準備を行う
                calc.onOperatorButtonClick(2);
                //display.setText(calc.doCalc("/"));
                break;
            case R.id.plus_button :     //足し算準備
                calc.onOperatorButtonClick(3);
                //display.setText(calc.doCalc("+"));
                break;
            case R.id.minus_button :    //引き算準備
                calc.onOperatorButtonClick(4);
                //display.setText(calc.doCalc("-"));
                break;
            case R.id.dot_button :      //小数点を表示
                display.setText(calc.inputData("."));
                break;
            case R.id.equal_button :    //=ボタンを押されたら演算を行い結果を表示
                display.setText(calc.doCalc());
                break;
        }
    }
}
