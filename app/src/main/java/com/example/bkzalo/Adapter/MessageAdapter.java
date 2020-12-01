package com.example.bkzalo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bkzalo.ChatActivity;
import com.example.bkzalo.Model.Chat;
import com.example.bkzalo.Model.User;
import com.example.bkzalo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    public static final int MES_LEFT = 0;
    public static final int MES_RIGTH = 1;

    //fields
    private Context mContext;
    private List<Chat> mChat;
    private String image_URL;

    FirebaseUser current_user;

    //constructor
    public MessageAdapter(Context mContext, List<Chat> mChat, String image_URL) {
        this.mContext = mContext;
        this.mChat = mChat;
        this.image_URL = image_URL;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == MES_RIGTH){
            view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false);
        }
        return new MessageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = mChat.get(position);

        holder.show_message.setText(chat.getMessage());

        if(image_URL.equals("default")){
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(mContext).load(image_URL).into(holder.profile_image);
        }

        if(position == mChat.size()-1){     // check for the last message
            if(chat.getIsSeen()){
                holder.txt_seen.setText("Đã xem");
            } else {
                holder.txt_seen.setText("Đã gởi");
            }
        } else {
            holder.txt_seen.setVisibility(View.GONE);   // if not last message then not show seen or delivered
        }
    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder{

        //fields
        public TextView show_message;
        public ImageView profile_image;
        public TextView txt_seen;

        // implement super constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            show_message = itemView.findViewById(R.id.show_message);
            profile_image = itemView.findViewById(R.id.profile_image);
            txt_seen = itemView.findViewById(R.id.txt_seen);
        }
    }

    @Override
    public int getItemViewType(int position) {
        current_user = FirebaseAuth.getInstance().getCurrentUser();
        // chat nào mà người gởi là current user thì hiển thị bên phải
        if(mChat.get(position).getSender().equals(current_user.getUid())){
            return MES_RIGTH;
        } else
        {
            return MES_LEFT;
        }
    }
}

