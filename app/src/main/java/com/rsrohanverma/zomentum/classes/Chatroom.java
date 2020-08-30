package com.rsrohanverma.zomentum.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Chatroom implements Parcelable {

    private String title;
    private String chatroom_id;
    String userdp;
    String astroId;
    String userId;
    String timestamp="0";
    String lastMessage="";
    String unreadMessageCount="";

    public Chatroom(String title, String chatroom_id, String userdp, String astroId, String userId, String timestamp, String lastMessage, String unreadMessageCount) {
        this.title = title;
        this.chatroom_id = chatroom_id;
        this.userdp = userdp;
        this.astroId = astroId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.lastMessage = lastMessage;
        this.unreadMessageCount = unreadMessageCount;
    }

    public String getUserdp() {
        return userdp;
    }

    public void setUserdp(String userdp) {
        this.userdp = userdp;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(String unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Chatroom(String title, String chatroom_id) {
        this.title = title;
        this.chatroom_id = chatroom_id;
    }

    public Chatroom() {

    }

    public String getAstroId() {
        return astroId;
    }

    public void setAstroId(String astroId) {
        this.astroId = astroId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    protected Chatroom(Parcel in) {
        title = in.readString();
        chatroom_id = in.readString();
        astroId = in.readString();
        userId = in.readString();
        timestamp = in.readString();
        lastMessage = in.readString();
        unreadMessageCount = in.readString();
    }

    public static final Creator<Chatroom> CREATOR = new Creator<Chatroom>() {
        @Override
        public Chatroom createFromParcel(Parcel in) {
            return new Chatroom(in);
        }

        @Override
        public Chatroom[] newArray(int size) {
            return new Chatroom[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChatroom_id() {
        return chatroom_id;
    }

    public void setChatroom_id(String chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "title='" + title + '\'' +
                ", chatroom_id='" + chatroom_id + '\'' +
                ", astroId='" + astroId + '\'' +
                ", userId='" + userId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", lastMessage='" + lastMessage + '\'' +
                ", unreadMessageCount='" + unreadMessageCount + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(chatroom_id);
        dest.writeString(astroId);
        dest.writeString(userId);
        dest.writeString(timestamp);
        dest.writeString(lastMessage);
        dest.writeString(unreadMessageCount);

    }
}
