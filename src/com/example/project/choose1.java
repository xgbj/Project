package com.example.project;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class choose1 extends Activity {
	     private  EditText edt1,edt2,question,A,B,C,D;
	     private  Button finish;
	     private  RadioButton a,b,c,d;
	     MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(choose1.this,"Answer.db", 
	        		null, 1);
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.choose1);
	        finish = (Button)findViewById(R.id.button1);
	        question = (EditText)findViewById(R.id.editText1);
	        A = (EditText)findViewById(R.id.editText2);
	        B = (EditText)findViewById(R.id.EditText01);
	        C = (EditText)findViewById(R.id.EditText02);
	        D = (EditText)findViewById(R.id.EditText03);
	        b = (RadioButton)findViewById(R.id.radioButton1);
	        d = (RadioButton)findViewById(R.id.radioButton2);
	        c = (RadioButton)findViewById(R.id.radioButton3);
	        a = (RadioButton)findViewById(R.id.radioButton4);
	        finish.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String Question = question.getText().toString();
			        String _A = A.getText().toString();
			        String _B = B.getText().toString();
			        String _C = C.getText().toString();
			        String _D = D.getText().toString();
			        int   key ;
			        //
			        if(a.isChecked())key=1;
			        else if(b.isChecked())key=2;
			        else if(c.isChecked())key=3;
			        else if(d.isChecked())key=4;
			        else 
			        {
			        	Toast.makeText(choose1.this,"请为题目设计一个答案",Toast.LENGTH_LONG).show();
			        	return ;
			        }
			      
					SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
				    ContentValues cv = new ContentValues();
				    cv.put("title", Question);
				    cv.put("A", _A);
				    cv.put("B", _B);
				    cv.put("C", _C);
				    cv.put("D", _D);
				    cv.put("choose_num",4);
				    cv.put("key", key);  
				    db.insert("Answertable", null, cv);
				    Toast.makeText(choose1.this,"添加到数据库成功",Toast.LENGTH_LONG).show();
				    Intent intent = new Intent();
				    intent.setClass(choose1.this, MainActivity.class);
				    startActivity(intent);
				    db.close();
				}
			});
	        //对取得的数据进行保存
	       
	 }
}
