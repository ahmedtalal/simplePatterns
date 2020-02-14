package com.alyndroid.architecturepatternstutorialshomework.MVVM;

import androidx.lifecycle.MutableLiveData;

import com.alyndroid.architecturepatternstutorialshomework.Models.MathOperations;

public class ViewModell extends androidx.lifecycle.ViewModel {
   public MutableLiveData<Integer> mutableLiveData =  new MutableLiveData<>() ;

    private int getMultiOperation(){
        MathOperations mathOperations = new MathOperations() ;
        return mathOperations.multOperation() ;
    }
    public void setMultiResult(){
        mutableLiveData.postValue(getMultiOperation());
    }

}
