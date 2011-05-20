package org.example.EssEmmEss;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity implements EssemmessListener {

	Essemmess mServer = EssemmessHelper.getServer( this );
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				switch(v.getId()){
				case R.id.button1:
					Intent explicit = new Intent(Main.this, Read.class);
					startActivity(explicit);
					break;
				
				}

				EditText tagText = (EditText) findViewById(R.id.editText1);
				EditText medText = (EditText) findViewById(R.id.editText2);

				mServer.post( tagText.getText().toString(), medText.getText().toString());
				
				Toast toast = Toast.makeText(getApplicationContext(),
						tagText.getText() + " \n " + medText.getText(),
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();

				tagText.setText("");
				medText.setText("");
			}
		});

	}

	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}

}