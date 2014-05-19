package com.osiatis.moocandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.osiatis.moocandroid.model.Message;

import java.util.ArrayList;


public class DisplayMessageActivity extends Activity {

    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        messageAdapter = new MessageAdapter(this, new ArrayList<Message>());

        ((ListView)findViewById(R.id.listViewMessage)).setAdapter(messageAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void postMessage(View view){
        EditText editTextMsg = (EditText) findViewById(R.id.editTextMessage);
        String message = editTextMsg.getText().toString();
        //TODO: validate input

        messageAdapter.add(new Message(((MoocApplication)getApplicationContext()).getUserName() + " : ",message));
        messageAdapter.notifyDataSetChanged();

    }
}
