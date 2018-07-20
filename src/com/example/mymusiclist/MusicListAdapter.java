package com.example.mymusiclist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MusicListAdapter extends BaseAdapter {
	private final static String TAG = "MusicListAdapter";
	private LayoutInflater inflater;
	private Context mContext;
	private ArrayList<Mp3Info> mList;
public MusicListAdapter(Context context, ArrayList<Mp3Info> list){
	mContext = context;
	mList = list;
	inflater = LayoutInflater.from(context);
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		if(convertView != null){
			view = convertView;
		} else {
			view = inflater.inflate(R.layout.listview_item, parent, false);
		}
	    TextView  title = (TextView)view.findViewById(R.id.music_title);
	    TextView artist = (TextView) view.findViewById(R.id.music_artist);
	    TextView duration = (TextView) view.findViewById(R.id.music_duration);
	    String music_title = mList.get(position).getTitle();
	    String music_artist = mList.get(position).getArtist();
	    long music_duration = mList.get(position).getDuration();
	    title.setText(music_title);
	    if(music_artist.equals("<unknown>")){	    	
	    	artist.setText("未知艺术家");
	    }else{
	    	artist.setText(music_artist);
	    }
	    Log.d(TAG, "music_artist============="+music_artist);
	    duration.setText(getStringTime(music_duration));
		return view;
	}
public String getStringTime(long duration){
	   SimpleDateFormat sDateFormat = new SimpleDateFormat("mm:ss");
       return sDateFormat.format(new Date(duration));
}
}
