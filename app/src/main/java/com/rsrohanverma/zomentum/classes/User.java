package com.rsrohanverma.zomentum.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    private String user_id;
    private String username;
    String userDp;

    public User(String email, String user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }

    public User() {

    }

    protected User(Parcel in) {
        user_id = in.readString();
        username = in.readString();
        userDp = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserDp() {
        return userDp;
    }

    public void setUserDp(String userDp) {
        this.userDp = userDp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", userDp='" + userDp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(username);
        dest.writeString(userDp);
    }
}
