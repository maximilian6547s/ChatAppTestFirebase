package com.demo.chatapptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {

    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    public MessagesAdapter() {
        messages = new ArrayList<>();
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_message, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        Message message = messages.get(position);
        String author = message.getAuthor();
        String text = message.getMessageText();
        String imageUrl = message.getImageUrl();
        holder.textViewAuthor.setText(author);
        holder.textViewAuthor.setText(messages.get(position).getAuthor());
        if (text != null && !text.isEmpty()) {
            holder.textViewMessageText.setText(messages.get(position).getMessageText());
            holder.imageViewImage.setVisibility(View.GONE);
        } else if(imageUrl != null && !imageUrl.isEmpty()) {
            holder.imageViewImage.setVisibility(View.VISIBLE);
            Picasso.get().load(imageUrl).into(holder.imageViewImage);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewAuthor;
        private TextView textViewMessageText;
        private ImageView imageViewImage;


        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewMessageText = itemView.findViewById(R.id.textViewMessageText);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);

        }
    }
}
