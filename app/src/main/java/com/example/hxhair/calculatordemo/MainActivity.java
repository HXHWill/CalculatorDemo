package com.example.hxhair.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int target=0;//record the previous is opeartion or num. 0 is num; 1 is operation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resultOpClick(View view)
    {
        TextView text=(TextView) findViewById(R.id.textView);
        int ID=view.getId();
        switch (ID)
        {
            case R.id.clearBt:
                text.setText("");
                break;
            case R.id.Equ:

                text.setText(""+calcu(text.getText().toString()));
                break;

        }

    }
    public void OpClick(View view)
    {
        //if(target==1)
            //return;
        int ID=view.getId();
        String operation="";
        TextView text=(TextView)findViewById(R.id.textView);
        switch(ID)
        {
            case R.id.Add:
                operation="+";
                break;
            case R.id.Min:
                operation="-";
                break;
            case R.id.Mul:
                operation="*";
                break;
            case R.id.Div:
                operation="/";
                break;

        }

        String result = text.getText().toString();
        if (target==1) {

            result=result.substring(0, result.length()-1);
        }

        text.setText(result+operation);
        target=1;//the last character is operation
    }
    public void NumClick(View view)
    {
        int ID=view.getId();
        int Num=0;
        TextView text=(TextView)findViewById(R.id.textView);
        switch (ID)
        {
            case R.id.Num0:
                Num=0;break;
            case R.id.Num1:
                Num=1;break;
            case R.id.Num2:
                Num=2;break;
            case R.id.Num3:
                Num=3;break;
            case R.id.Num4:
                Num=4;break;
            case R.id.Num5:
                Num=5;break;
            case R.id.Num6:
                Num=6;break;
            case R.id.Num7:
                Num=7;break;
            case R.id.Num8:
                Num=8;break;
            case R.id.Num9:
                Num=9;break;


        }

        //normally the calculator has 0 as start number
        if(text.getText().toString().equals("0")) {

            text.setText("" + Num);
        }
        else
            text.setText(text.getText()+""+Num);

        target=0;


    }

    public Double calcu(String str)
    {
        ArrayList<Double> numList=new ArrayList<Double>();
        ArrayList<Character> opList=new ArrayList<Character>();
        char[] temp=str.toCharArray();
        int startIndex=0;

        for(int i=0;i<str.length();i++)
        {
            if(temp[i]=='+'|| temp[i]=='-'||
                    temp[i]=='*'|| temp[i]=='/')
            {
                opList.add(temp[i]);
                numList.add(Double.parseDouble(str.substring(startIndex,i)));
                startIndex=i+1;
            }
            else if(i==str.length()-1)
            {
                numList.add(Double.parseDouble(str.substring(startIndex,i+1))) ;
            }

        }



        while(opList.indexOf('*')!=-1)
        {
            int mulIndex= opList.indexOf('*');
            double returnNum=numList.get(mulIndex)*numList.get(mulIndex+1);
            numList.set(mulIndex,returnNum);
            numList.remove(mulIndex+1);
            opList.remove(mulIndex);

        }

        while(opList.indexOf('/')!=-1)
        {
            int mulIndex= opList.indexOf('/');
            double returnNum=numList.get(mulIndex)/numList.get(mulIndex+1);
            numList.set(mulIndex,returnNum);
            numList.remove(mulIndex+1);
            opList.remove(mulIndex);

        }
        while(opList.indexOf('+')!=-1)
        {
            int mulIndex= opList.indexOf('+');
            double returnNum=numList.get(mulIndex)+numList.get(mulIndex+1);
            numList.set(mulIndex,returnNum);
            numList.remove(mulIndex+1);
            opList.remove(mulIndex);

        }
        while(opList.indexOf('-')!=-1)
        {
            int mulIndex= opList.indexOf('+');
            double returnNum=numList.get(mulIndex)-numList.get(mulIndex+1);
            numList.set(mulIndex,returnNum);
            numList.remove(mulIndex+1);
            opList.remove(mulIndex);

        }


        return numList.get(0);

    }
}
