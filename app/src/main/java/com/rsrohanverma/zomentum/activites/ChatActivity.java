package com.rsrohanverma.zomentum.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsrohanverma.zomentum.R;
import com.rsrohanverma.zomentum.adapters.ChatMessageRecyclerAdapter;
import com.rsrohanverma.zomentum.classes.ChatMessage;
import com.rsrohanverma.zomentum.classes.Chatroom;
import com.rsrohanverma.zomentum.classes.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {
    String usersId;
    RelativeLayout typeMsg;
    ImageView iv_back;


    private String TAG = "Chat Activity";

    //widgets
    private EditText mMessage;

    //vars

    private RecyclerView mChatMessageRecyclerView;
    private ChatMessageRecyclerAdapter mChatMessageRecyclerAdapter;

    private ArrayList<ChatMessage> mMessages = new ArrayList<>();
    private Set<String> mMessageIds = new HashSet<>();
    private ArrayList<User> mUserList = new ArrayList<>();
    private ImageView sendButton;
    private TextView chatuserName;
    private String chatroomId;
    private String s;
    private String clientName, clientDp;
    private Chatroom chatroom;
    private String astroId;
    private boolean timerOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        typeMsg = findViewById(R.id.typeMsg);
        mMessage = findViewById(R.id.iv_edit_text);
        mChatMessageRecyclerView = findViewById(R.id.rv_chat_list);
        sendButton = findViewById(R.id.iv_send_text);
        chatuserName = findViewById(R.id.ChatUserName);

        chatroom = new Chatroom();
        usersId = getIntent().getStringExtra("uuid");
        chatroomId = getIntent().getStringExtra("cid");
        clientName = getIntent().getStringExtra("uname");
        clientDp = getIntent().getStringExtra("udp");
        chatuserName.setText(clientName);
        initChatroomRecyclerView();
    }

    private void initChatroomRecyclerView() {

        for(int i = 0;i<20;i++)
        {
            mMessages.add(new ChatMessage("Some dummy text", "0", (System.currentTimeMillis()-(i*500000))+""));
        }

        mChatMessageRecyclerAdapter = new ChatMessageRecyclerAdapter(mMessages, new ArrayList<User>(), this);
        mChatMessageRecyclerView.setAdapter(mChatMessageRecyclerAdapter);
        mChatMessageRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mChatMessageRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    mChatMessageRecyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (mMessages.size() > 0) {
                                mChatMessageRecyclerView.smoothScrollToPosition(
                                        mChatMessageRecyclerView.getAdapter().getItemCount() - 1);
                            }

                        }
                    }, 100);
                }
            }
        });

    }
}