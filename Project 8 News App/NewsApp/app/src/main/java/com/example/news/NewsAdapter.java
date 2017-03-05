package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> mNewsList = new ArrayList<>();

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
        mNewsList = news;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_layout, parent, false);
        }

        News news = getItem(position);

        TextView titleText = (TextView) convertView.findViewById(R.id.title_text);
        titleText.setText(news.getTitle());

        TextView sectionText = (TextView) convertView.findViewById(R.id.section_text);
        sectionText.setText(news.getSection());

        TextView authorText = (TextView) convertView.findViewById(R.id.author_text);
        if (news.getAuthor().equals("")) {
            authorText.setText(R.string.no_author);
        } else {

            authorText.setText(news.getAuthor());
        }

        TextView dateText = (TextView) convertView.findViewById(R.id.date_text);
        dateText.setText(formatDate(news.getDate()));

        TextView trailText = (TextView) convertView.findViewById(R.id.trail_text);
        trailText.setText(news.getTrailText());

        return convertView;

    }

    private String formatDate(String date) {

        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat dateOutput = new SimpleDateFormat("LLL dd, yyyy - h:mm a");
        String dateReturn = null;
        try {
            dateReturn = dateOutput.format(dateInput.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateReturn;
    }

    public void setNewsList(List<News> newsList) {

        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }
}
