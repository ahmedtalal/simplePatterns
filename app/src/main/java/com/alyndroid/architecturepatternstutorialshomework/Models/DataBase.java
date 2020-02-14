package com.alyndroid.architecturepatternstutorialshomework.Models;

import com.alyndroid.architecturepatternstutorialshomework.Models.NumberModel;

public class DataBase {

    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
