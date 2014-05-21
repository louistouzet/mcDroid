package com.osiatis.moocandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.osiatis.moocandroid.tech.MessageAdapter;
import com.osiatis.moocandroid.tech.MoocApplication;
import com.osiatis.moocandroid.R;
import com.osiatis.moocandroid.model.Message;

import java.util.ArrayList;


public class DisplayMessageActivity extends Activity {

    /**
     * MessageAdapter to convert @see Message to item of the @see ListView
     */
    private MessageAdapter messageAdapter;
    /**
     * @see EditText to type the message to post
     */
    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        messageAdapter = new MessageAdapter(this, new ArrayList<Message>());

        ((ListView)findViewById(R.id.listViewMessage)).setAdapter(messageAdapter);
        editTextMsg = (EditText) findViewById(R.id.editTextMessage);
        //Add listener to handle ok button on keyboard
        editTextMsg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    postMessage(null);
                }
                return false;
            }
        });
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

        String message = editTextMsg.getEditableText().toString();
        //TODO: validate input
        editTextMsg.setText("");
        messageAdapter.add(new Message(((MoocApplication)getApplicationContext()).getUserName() + " : ",message));
        messageAdapter.notifyDataSetChanged();

    }
}
