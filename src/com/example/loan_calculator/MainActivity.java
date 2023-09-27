package com.example.loan_calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	EditText etLoanAmount,etInterestRate,etLoanPeriod;
    TextView tvResult1,tvResult2;
	
    protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	etLoanAmount=(EditText)findViewById(R.id.etLoanAmount);
	etInterestRate=(EditText)findViewById(R.id.etInterestRate);
	etLoanPeriod=(EditText)findViewById(R.id.etLoanPeriod);
	tvResult1=(TextView)findViewById(R.id.tvResult1);
	tvResult2=(TextView)findViewById(R.id.tvResult2);
    }
	
   
public void showLoanPayments(View v){
	
	String LoanAmountstr=etLoanAmount.getText().toString();
	String InterestRatestr=etInterestRate.getText().toString();
	String LoanPeriodstr=etLoanPeriod.getText().toString();
	if(!LoanAmountstr.equals("") && !InterestRatestr.equals("") && !LoanPeriodstr.equals("")){
    double LoanAmount=Double.parseDouble(LoanAmountstr);
    double InterestRate=Double.parseDouble(InterestRatestr);
    double LoanPeriod=Double.parseDouble(LoanPeriodstr);
    double r=InterestRate/1200;
    double r1=Math.pow(r+1,LoanPeriod);
    double result1=(r+(r/(r1-1)))*LoanAmount;
    double result2=result1*LoanPeriod;
    tvResult1.setText("Monthly Payment= "+result1);
    tvResult2.setText("Total Payment= "+result2);
	}
	else{
		Toast t=Toast.makeText(getApplicationContext(),"Please enter all the inputs",
				Toast.LENGTH_LONG);
		t.show();
	}
}   
}