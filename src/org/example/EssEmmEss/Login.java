// login

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements OnClickListener, EssemmessListener{

	Essemmess server;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		server = EssemmessHelper.getServer(this);
		server.addEssemmessEventListener(this);
		
		

		
		Button Login = (Button) findViewById(R.id.button1);
		Login.setOnClickListener(this);
	}
		
	public void onClick(View v) {
		
		EditText edittext1 = (EditText) findViewById(R.id.editText1);
		EditText edittext2 = (EditText) findViewById(R.id.editText2);
			
			String username = edittext1.getText().toString();
			String password = edittext2.getText().toString();
			
			server.login(username, password);
			};
		
	

	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		
	}

	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		if( evt.getLoggedin() == true){
			Intent explicit = new Intent(Login.this, Main.class);
			startActivity(explicit);
		}
	}

	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		
	}
}