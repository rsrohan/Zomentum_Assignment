package com.rsrohanverma.zomentum.adapters;

import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import com.rsrohanverma.zomentum.R;
import com.rsrohanverma.zomentum.classes.ChatMessage;
import com.rsrohanverma.zomentum.classes.User;

import java.util.ArrayList;
import java.util.Objects;

public class ChatMessageRecyclerAdapter extends RecyclerView.Adapter<ChatMessageRecyclerAdapter.ViewHolder> {

    private ArrayList<ChatMessage> mMessages = new ArrayList<>();
    private ArrayList<User> mUsers = new ArrayList<>();
    private Context mContext;

    public ChatMessageRecyclerAdapter(ArrayList<ChatMessage> messages,
                                      ArrayList<User> users,
                                      Context context) {
        this.mMessages = messages;
        this.mUsers = users;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_messages, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        if (position%2==0) {
            holder.receivedChat.setVisibility(View.GONE);
            holder.sentChat.setVisibility(View.VISIBLE);
            holder.receivedLL.setVisibility(View.GONE);
            holder.receivedStatus.setVisibility(View.GONE);
            holder.sentStatus.setVisibility(View.VISIBLE);

            ((ViewHolder) holder).sentChat.setText(mMessages.get(position).getMessage());

        } else {
            holder.receivedChat.setVisibility(View.VISIBLE);
            holder.sentChat.setVisibility(View.GONE);
            holder.receivedLL.setVisibility(View.VISIBLE);
            holder.sentStatus.setVisibility(View.GONE);
            holder.receivedStatus.setVisibility(View.VISIBLE);


            ((ViewHolder) holder).receivedChat.setText(mMessages.get(position).getMessage());
        }
        long seconds = Long.parseLong(mMessages.get(position).getTimestamp());

        long timeDifference = System.currentTimeMillis() - (seconds);

        int hrs = (int) (timeDifference / 3600000);
        if (hrs <= 24) {
            holder.receivedStatus.setText(DateFormat.format("hh:mm a", (seconds)).toString());
            holder.sentStatus.setText(DateFormat.format("hh:mm a", (seconds)).toString());

        } else {
            if (hrs <= 48) {
                holder.receivedStatus.setText( ("Yesterday " + DateFormat.format("hh:mm a", seconds).toString()));
                holder.sentStatus.setText( ("Yesterday " + DateFormat.format("hh:mm a", seconds).toString()));

            } else {
                holder.receivedStatus.setText( DateFormat.format("dd MMM - hh:mm a", seconds).toString());
                holder.sentStatus.setText( DateFormat.format("dd MMM - hh:mm a", seconds).toString());

            }
        }
    }


    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sentChat;
        TextView receivedChat;
        TextView receivedStatus;
        TextView sentStatus;
        View view;
        LinearLayout receivedLL;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            sentChat = view.findViewById(R.id.tv_sent_msg);
            receivedChat = view.findViewById(R.id.tv_received_msg);
            receivedStatus = view.findViewById(R.id.tv_recieved_status);
            sentStatus = view.findViewById(R.id.tv_sent_status);
            receivedLL = view.findViewById(R.id.receivedLL);
        }
    }

}
















