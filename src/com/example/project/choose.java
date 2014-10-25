package com.example.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class choose extends Activity{
	OnClickListener listen1;
	 private Button add;
	 int choose_number=0;
	   @Override 
	   public void onCreate(Bundle savedInstanceState) {  
	       super.onCreate(savedInstanceState);  
	       setContentView(R.layout.choose);  
	       final LinearLayout layout = (LinearLayout) this.findViewById(R.id.root); 
	       
	       //android:scrollbars="vertical"
	      add=(Button)findViewById(R.id.add);
	      
	       //添加组件
	      // layout2.addView(finish);         
	       listen1 = new OnClickListener() {  
	        public void onClick(View v) {  
	        
	            if(choose_number<10 ) {
	            
	            final TextView text=new TextView(v.getContext());
	            text.setText((char)('A'+choose_number)+":");
	            choose_number++;
	            final EditText edt=new EditText(v.getContext()); 
	            layout.addView(text); 
	            layout.addView(edt);
	            
	            }
	              
	              
	        }  
	    };  
	     add.setOnClickListener(listen1); } 
 }  
