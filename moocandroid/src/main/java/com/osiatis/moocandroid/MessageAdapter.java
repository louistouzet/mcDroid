package com.osiatis.moocandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.osiatis.moocandroid.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loul on 19/05/14.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

    private List<Message> messageList = new ArrayList<Message>();
    private LayoutInflater li;
    private Context context;

    public MessageAdapter(Context context, ArrayList<Message> itemsArrayList) {

        super(context, R.layout.layout_message_item, itemsArrayList);
        li = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.messageList = itemsArrayList;
    }

    @Override
    public void add(Message object) {
        super.add(object);
        if(messageList.size() > 10){
            messageList.remove(0);
        }
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Message getItem(int i) {
        return messageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = li.inflate(R.layout.layout_message_item, null);
        }

        TextView userNameLabel = (TextView) view.findViewById(R.id.textViewUserName);
        userNameLabel.setText(messageList.get(i).getUser());
        ((TextView)view.findViewById(R.id.textViewMessageContent)).setText(messageList.get(i).getMessage());

        return view;
    }
}
