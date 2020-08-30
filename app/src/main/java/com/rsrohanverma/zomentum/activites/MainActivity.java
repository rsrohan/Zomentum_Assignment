package com.rsrohanverma.zomentum.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rsrohanverma.zomentum.R;
import com.rsrohanverma.zomentum.adapters.ChatroomRecyclerAdapter;
import com.rsrohanverma.zomentum.classes.Chatroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Chatroom> mChatrooms = new ArrayList<>();
    private Set<String> mChatroomIds = new HashSet<>();
    private ChatroomRecyclerAdapter mChatroomRecyclerAdapter;
    private RecyclerView mChatroomRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChatroomRecyclerView = findViewById(R.id.rv_astro_chat);
        initChatroomRecyclerView();
    }
    private void initChatroomRecyclerView() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("John Doe");
        names.add("Robert");
        names.add("Carl");
        names.add("Daryl Dixon");
        names.add("Maggie");
        names.add("Glenn");
        ArrayList<String> lastMessages = new ArrayList<>();
        lastMessages.add("See ya!");
        lastMessages.add("Okay cool...");
        lastMessages.add("Sounds great :)");
        lastMessages.add("Thanks!");
        lastMessages.add("Hmmmm...");
        lastMessages.add("Zomentum looks good!");
        lastMessages.add("See you soon...");
        ArrayList<String> unreads = new ArrayList<>();
        unreads.add("2");
        unreads.add("5");
        unreads.add("5");
        unreads.add("1");
        unreads.add("4");
        unreads.add("2");
        unreads.add("1");
        for (int i =0;i<7;i++)
        {
            Chatroom chatroom = new Chatroom(names.get(i), i+"", null, i+"", i+"", (System.currentTimeMillis()-(i*500000))+"", lastMessages.get(i), unreads.get(i));
            mChatrooms.add(chatroom);
        }
        mChatroomRecyclerAdapter = new ChatroomRecyclerAdapter(getApplicationContext(), mChatrooms);
        mChatroomRecyclerView.setAdapter(mChatroomRecyclerAdapter);
        mChatroomRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}