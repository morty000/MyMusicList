package com.example.mymusiclist;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity {
private ListView listView;
private ArrayList<Mp3Info> musicList = new ArrayList<Mp3Info>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
        listView = (ListView) findViewById(R.id.listView1);
        musicList = getMp3Infos();
        MusicListAdapter adapter = new MusicListAdapter(this, musicList);
        listView.setAdapter(adapter);
	}
	public ArrayList<Mp3Info> getMp3Infos() {  //获取音乐列表信息
	    Cursor cursor = getContentResolver().query(  
	        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,  
	        MediaStore.Audio.Media.DEFAULT_SORT_ORDER);  
	    ArrayList<Mp3Info> mp3Infos = new ArrayList<Mp3Info>();  
	    for (int i = 0; i < cursor.getCount(); i++) {  
	        Mp3Info mp3Info = new Mp3Info();  
	        cursor.moveToNext();  
	        long id = cursor.getLong(cursor  
	            .getColumnIndex(MediaStore.Audio.Media._ID));   //音乐id  
	        String title = cursor.getString((cursor   
	            .getColumnIndex(MediaStore.Audio.Media.TITLE)));//音乐标题  
	        String artist = cursor.getString(cursor  
	            .getColumnIndex(MediaStore.Audio.Media.ARTIST));//艺术家  
	        long duration = cursor.getLong(cursor  
	            .getColumnIndex(MediaStore.Audio.Media.DURATION));//时长  
	        long size = cursor.getLong(cursor  
	            .getColumnIndex(MediaStore.Audio.Media.SIZE));  //文件大小  
	        String url = cursor.getString(cursor  
	            .getColumnIndex(MediaStore.Audio.Media.DATA));              //文件路径  
	    int isMusic = cursor.getInt(cursor  
	        .getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));//是否为音乐  
	    if (isMusic != 0) {     //只把音乐添加到集合当中  
	        mp3Info.setId(id);  
	        mp3Info.setTitle(title);  
	        mp3Info.setArtist(artist);  
	        mp3Info.setDuration(duration);  
	        mp3Info.setSize(size);  
	        mp3Info.setUrl(url);  
	        mp3Infos.add(mp3Info);  
	        }  
	    }  
	return mp3Infos;  
	}  

}
