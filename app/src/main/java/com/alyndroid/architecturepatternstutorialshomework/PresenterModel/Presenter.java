package com.alyndroid.architecturepatternstutorialshomework.PresenterModel;

import com.alyndroid.architecturepatternstutorialshomework.Models.MathOperations;

public class Presenter {

    DevisionInterface devisionInterface ;

    public Presenter(DevisionInterface devisionInterface) {
        this.devisionInterface = devisionInterface;
    }

    private int getDevisionOp(){
        MathOperations mathOperations =  new MathOperations() ;
        return mathOperations.devsionOperation() ;
    }


    public void setResult(){
        devisionInterface.getDevisionOperation(getDevisionOp());
    }
}
