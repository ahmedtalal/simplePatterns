package com.alyndroid.architecturepatternstutorialshomework.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alyndroid.architecturepatternstutorialshomework.MVVM.ViewModell;
import com.alyndroid.architecturepatternstutorialshomework.Models.MathOperations;
import com.alyndroid.architecturepatternstutorialshomework.PresenterModel.DevisionInterface;
import com.alyndroid.architecturepatternstutorialshomework.PresenterModel.Presenter;
import com.alyndroid.architecturepatternstutorialshomework.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , DevisionInterface {


    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;

    Presenter presenter ;
    ViewModell viewModell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


         // Here I used MVP architecture pattern
        presenter =  new Presenter(this::getDevisionOperation) ;

        //Here I used MVVM architecture pattern
        viewModell = new ViewModelProvider(this).get(ViewModell.class) ;
        viewModell.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTextView.setText(integer + "");
            }
        });

         plusButton.setOnClickListener(this::onClick);
         divButton.setOnClickListener(this::onClick);
         mulButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.plus_button :
                // Here I used MVC architecture pattern
                MathOperations mathOperations =  new MathOperations() ;
              plusResultTextView.setText(String.valueOf(mathOperations.plusOperation()));
              break;
            case R.id.div_button :
                presenter.setResult();
                break;
            case R.id.mul_button:
                viewModell.setMultiResult();
        }
    }

    @Override
    public void getDevisionOperation(int result) {
        divResultTextView.setText(String.valueOf(result));
    }
}
