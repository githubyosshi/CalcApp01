package com.bird_brown.calcapp01;

import java.text.DecimalFormat;

public class Calc {         //計算クラス
    private String total;   //合計データを格納する変数
    private String input;   //入力データを格納する変数
    private int operatorId; //演算方法（＋、ー、×、÷）を格納する変数

    public Calc() {}

    public Calc(String total, String input) {   //合計データと入力データを設定するコンストラクタ
        this.total = total;
        this.input = input;
    }

    //数字および「.」ボタンが押された時に呼び出されるinputDataメソッド
    public String inputData(String data) {
        //「.」ボタンが押されたら「.」を付加するが、既に入力している場合は付加されない
        if (data.equals(".")) {
            if (input.indexOf(".") == -1) {
                input += ".";
            }
        } else {
            //「0」ボタンが押されたら後ろに「0」を付加するが、入力データがない場合は付加されない
            if (data.equals("0")) {
                if (!input.equals("0")) {
                    input += data;
                }
            } else {
                //「0」ボタン以外が押された時は後ろに付加又は、０の倍は押された数字を最初の入力値にする
                if (input.equals("0")) {
                    input = data;
                } else {
                    input += data;
                }
            }
        }
        return input;   //入力された数字文字列をTextViewに表示させるため返す
    }

    public String clear() {     //合計データと入力データを「０」に設定するメソッド
        total = "0";
        input = "0";

        //数字の表示書式を設定
        DecimalFormat df = new DecimalFormat("0.###################");
        df.setMaximumIntegerDigits(17);     //整数部のさあ偉大桁数を17桁に指定
        return df.format(Double.parseDouble(total));
    }

    //演算ボタン+,-,x,÷が押されたら呼び出されるメソッド
    public void onOperatorButtonClick(int operatorId) {
        this.operatorId = operatorId;       //演算方法;,-,x,÷を記憶
        total = !total.equals("0") ? total : input;     //演算ボタンが押された時に合計を記憶
        input = "0";    //入力データを0とする
    }

    public String doCalc() {    //演算を行う時に呼び出されるdoCalcメソッド
        double result = Double.parseDouble(total);

        //合計データと入力データで演算方法+,-,x,÷により演算を行う
        switch(operatorId) {
            case 1 : result *= Double.parseDouble(input); break;
            case 2 : result /= Double.parseDouble(input); break;
            case 3 : result += Double.parseDouble(input); break;
            case 4 : result -= Double.parseDouble(input); break;
        }

        input = "0";        //入力データを０にする
        total = Double.toString(result);    //演算結果を合計データとする

        DecimalFormat df = new DecimalFormat("0.##################");
        df.setMaximumIntegerDigits(17);     //数字の表示形式を設定する
        return df.format(result);       //整数部の最大桁数を17桁に指定
    }

}
