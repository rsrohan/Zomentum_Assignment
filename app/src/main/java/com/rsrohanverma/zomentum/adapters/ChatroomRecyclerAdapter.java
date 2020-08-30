package com.rsrohanverma.zomentum.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.rsrohanverma.zomentum.R;
import com.rsrohanverma.zomentum.activites.ChatActivity;
import com.rsrohanverma.zomentum.classes.Chatroom;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatroomRecyclerAdapter extends RecyclerView.Adapter<ChatroomRecyclerAdapter.ViewHolder> {

    private ArrayList<Chatroom> mChatrooms = new ArrayList<>();

    Context context;
    public ChatroomRecyclerAdapter(Context context, ArrayList<Chatroom> chatrooms) {
        this.mChatrooms = chatrooms;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.chatName.setText(mChatrooms.get(position).getTitle());
        long seconds = Long.parseLong(mChatrooms.get(position).getTimestamp());

        long timeDifference = System.currentTimeMillis() - (seconds);

        int hrs = (int) (timeDifference / 3600000);
        if (hrs <= 24) {
            holder.chatTime.setText(DateFormat.format("hh:mm a", (seconds)).toString());
        } else {
            if (hrs <= 48) {
                holder.chatTime.setText( ("Yesterday " + DateFormat.format("hh:mm a", seconds).toString()));
            } else {
                holder.chatTime.setText( DateFormat.format("dd MMM - hh:mm a", seconds).toString());
            }
        }
        try{
            if (!mChatrooms.get(position).getUserdp().isEmpty()&&!mChatrooms.get(position).getUserdp().equals("null"))
            {
                Glide.with(context).load(mChatrooms.get(position).getUserdp()).into(holder.civ_acharya_dp);
            }
        }catch (Exception e){
        }
        holder.lastMessage.setText(mChatrooms.get(position).getLastMessage());
        holder.numMessages.setText(mChatrooms.get(position).getUnreadMessageCount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, ChatActivity.class);
                i.putExtra("uuid", mChatrooms.get(position).getUserId());
                i.putExtra("cid", mChatrooms.get(position).getChatroom_id());
                i.putExtra("uname", mChatrooms.get(position).getTitle());
                i.putExtra("udp", mChatrooms.get(position).getUserdp());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChatrooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView chatName;
        public TextView chatTime;
        public TextView lastMessage;
        public TextView numMessages;
        CircleImageView civ_acharya_dp;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            chatName = view.findViewById(R.id.ChatName);
            civ_acharya_dp = itemView.findViewById(R.id.civ_acharya_dp);
            chatTime = view.findViewById(R.id.ChatTime);
            lastMessage = view.findViewById(R.id.LastMessage);
            numMessages = view.findViewById(R.id.NumMessages);
        }


    }

}
















