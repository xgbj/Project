package com.example.project;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class answer extends Activity{
	private Button button1;
	private TextView q_num,q_title;
	private SQLiteDatabase mydb;
	private MySQLiteHelper mySQL = new MySQLiteHelper(answer.this,"Answer.db", 
     		null, 1);
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.answer);
	        final RadioGroup radiogruop = (RadioGroup) this.findViewById(R.id.radiogruop); 
	        mydb =mySQL.getReadableDatabase();
			q_num = (TextView)findViewById(R.id.q_num);
			q_title = (TextView)findViewById(R.id.q_title);
			final Cursor cursor = 
			mydb.query("Answertable", new String[]{"_id","title","A"
					,"B","C", "D","choose_num","key"},null,null,null,
					null,null);
			button1 = (Button)findViewById(R.id.button1);
			button1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					 if(cursor.moveToNext()) {
						    ////////////////////
						   int idindex = cursor.getColumnIndex("_id");
						   int id = cursor.getInt(idindex);
						   /////////////////
						   int titleindex = cursor.getColumnIndex("title");
						   String title = cursor.getString(titleindex);
						   //////////////////////////
						   int choose_numindex = cursor.getColumnIndex("choose_num");
						   int choose_num = cursor.getInt(choose_numindex);
						   //////////////////////////答案组件
						   for(int i=0;i<choose_num;i++) {
						   char temp=(char)('A'+i);
						   int Aindex = cursor.getColumnIndex(temp+"");
						   String A = cursor.getString(Aindex);
						   final RadioButton radio=new RadioButton(v.getContext());
						   radio.setText(temp+"."+A);
						   radiogruop.addView(radio);
						   }
						   /////////////////////////
						   q_num.setText(id+"");
						   q_title.setText(title);
						   
						   
					   }
					
				}
			});
		  
		 //  mydb.close();
		
			
			
	 }
}
