package org.zhibernate.domain;

import java.util.Calendar;
import java.util.Date;

public class Event {
	
	private Long id;

    private String title;
    private Date date;

    public Event() {}
    
    public Event(String title) {
    	this.title = title;
    	this.date = Calendar.getInstance().getTime();
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
