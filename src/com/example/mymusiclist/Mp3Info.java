package com.example.mymusiclist;

public class Mp3Info {
    long id;
    long duration;
    long size;
    String title;
    String url;
    String artist;
    public Mp3Info(){ }
    
	public Mp3Info(long id, long duration, long size, String title, String url,
			String artist) {
		super();
		this.id = id;
		this.duration = duration;
		this.size = size;
		this.title = title;
		this.url = url;
		this.artist = artist;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Mp3Info [id=" + id + ", duration=" + duration + ", size="
				+ size + ", title=" + title + ", url=" + url + ", artist="
				+ artist + "]";
	}
    
    
    
}
