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
        ArrayList<String> dps = new ArrayList<>();
        dps.add("https://cdn.statically.io/img/i.pinimg.com/originals/b8/65/71/b8657186950ab945c151481e0829047d.png");
        dps.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTcX3cu7MWvad2OKHE_dE3aieGx-3cbERqKsQ&usqp=CAU");
        dps.add("https://images-na.ssl-images-amazon.com/images/I/41ONa5HOwfL._SX425_.jpg");
        dps.add("https://data.whicdn.com/images/315751848/original.jpg");
        dps.add("https://fiverr-res.cloudinary.com/images/q_auto,f_auto/gigs/145157664/original/f51316a0de362f9fd056040d0fbc578bafcdf540/draw-cartoon-gaming-social-media-profile-picture.jpg");
        dps.add("https://data.whicdn.com/images/320568065/original.jpg");
        dps.add("https://image.freepik.com/free-vector/man-profile-cartoon_18591-58482.jpg");
        for (int i =0;i<7;i++)
        {
            Chatroom chatroom = new Chatroom(names.get(i), i+"", dps.get(i), i+"", i+"", (System.currentTimeMillis()-(i*500000))+"", lastMessages.get(i), unreads.get(i));
            mChatrooms.add(chatroom);
        }
        mChatroomRecyclerAdapter = new ChatroomRecyclerAdapter(getApplicationContext(), mChatrooms);
        mChatroomRecyclerView.setAdapter(mChatroomRecyclerAdapter);
        mChatroomRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}