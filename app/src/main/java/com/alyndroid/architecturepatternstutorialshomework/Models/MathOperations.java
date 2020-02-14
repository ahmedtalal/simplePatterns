package com.alyndroid.architecturepatternstutorialshomework.Models;

public class MathOperations {

   private  DataBase dataBase ;
   private NumberModel model ;
    public MathOperations() {
        dataBase =  new DataBase() ;
        model = dataBase.getNumbers() ;
    }

    // functions
    public  int plusOperation(){
         return model.getFirstNum() + model.getSecondNum() ;
    }

    public int multOperation(){
         return model.getFirstNum() * model.getSecondNum() ;
    }

    public int devsionOperation(){
        if (model.getSecondNum() == 0)
            return 0 ;
        else
            return model.getFirstNum() / model.getSecondNum() ;
    }
}
