package org.example.EssEmmEss;

import java.util.ArrayList;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import se.k3.goransson.andreas.essemmesslib.Post;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Read extends Activity implements OnClickListener, EssemmessListener{
	
	ListView listview;
	Essemmess mServer = EssemmessHelper.getServer(this);
	ArrayList <String> Posts;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		
		Posts = new ArrayList<String>();
		
		mServer.addEssemmessEventListener(this);
		
		listview = (ListView) findViewById(R.id.listView1);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Posts);
		
		listview.setAdapter(adapter);
		
		
		Button update = (Button) findViewById(R.id.button1);
		update.setOnClickListener(this);
	}

	public void onClick(View v) {

		switch(v.getId()){
		case R.id.button1:
			
			mServer.read("");
			
		
		}
		
	}

	public void NewEssemmessPosts(EssemmessReadEvent evt) {

		ArrayList<Post> newposts = evt.getPosts();
		
		for( Post p : newposts ){
			Posts.add(p.user + "" + p.tag + "" + p.message);
			
		}
		
		adapter.notifyDataSetChanged();
		
	}

	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		
	}

	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		
	}
	
	

}