package com.example.android_sport_project.result_page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_sport_project.R;
import com.example.android_sport_project.model.SportGame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SportGameResultAdapter extends RecyclerView.Adapter<SportGameResultAdapter.ScoreViewHolder> {

    private List<SportGame> sportGames = new ArrayList<>();

    public List<SportGame> getSportGames() {
        return sportGames;
    }

    public void addScore(SportGame sportGame) {
        sportGames.add(sportGame);
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
        switch (sportGames.get(position).getGameType()) {
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
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String GameDate = dateFormat.format(sportGames.get(position).getGameDate());

        holder.txtFirstTeam.setText(sportGames.get(position).getFirstTeamName());
        holder.txtScore.setText(sportGames.get(position).getFirstTeamCount() +":" + sportGames.get(position).getSecondTeamCount());
        holder.txtSecondTeam.setText(sportGames.get(position).getSecondTeamName());
        holder.txtDate.setText(GameDate);
    }

    @Override
    public int getItemCount() {
        return sportGames.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtFirstTeam;
        private TextView txtScore;
        private TextView txtSecondTeam;
        private TextView txtDate;

        public ScoreViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtFirstTeam = itemView.findViewById(R.id.txtFirstTeam);
            txtScore = itemView.findViewById(R.id.txtScore);
            txtSecondTeam = itemView.findViewById(R.id.txtSecondTeam);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
    }
}
