package com.example.android_sport_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private List<Score> scores = new ArrayList<>();

    public List<Score> getScores() {
        return scores;
    }

    public void addScore(Score score) {
        scores.add(score);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.instance_of_the_result, parent,
                false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        switch (scores.get(position).getType()) {
            case 1:
                holder.imageView.setImageResource(R.drawable.volley_ball);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.foot_ball);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.basket_ball);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.ic_crop_original_blue_24dp);
                break;
        }

        holder.txtFirstTeam.setText(scores.get(position).getFirstTeam());
        holder.txtScore.setText(scores.get(position).getScore());
        holder.txtSecondTeam.setText(scores.get(position).getSecondTeam());
        holder.txtDate.setText(scores.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtFirstTeam;
        private TextView txtScore;
        private TextView txtSecondTeam;
        private TextView txtDate;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtFirstTeam = itemView.findViewById(R.id.txtFirstTeam);
            txtScore = itemView.findViewById(R.id.txtScore);
            txtSecondTeam = itemView.findViewById(R.id.txtSecondTeam);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
    }
}
