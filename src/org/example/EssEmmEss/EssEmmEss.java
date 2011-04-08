package org.example.EssEmmEss;

import org.example.EssEmmEss.R;
import org.example.EssEmmEss.Submit;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class EssEmmEss extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        
        Tag = (EditText) findViewById(R.id.editText1);
        Message = (EditText) findViewById(R.id.editText2);
        
    }
    
    EditText Tag;
    EditText Message;
    
    public void onClick(View v) { 
    		String myTag = Tag.getText().toString();
    		String myMessage = Message.getText().toString();
    		Toast.makeText(this, myTag + " " + myMessage, Toast.LENGTH_SHORT).show();
    }
}
