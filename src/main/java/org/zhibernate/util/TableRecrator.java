package org.zhibernate.util;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.zhibernate.domain.Event;


public class TableRecrator {
	


    public static void main(String[] args) {
    	TableRecrator tableRecrator = new TableRecrator();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        tableRecrator.createAndStoreEvent("tittle", Calendar.getInstance().getTime(), session);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate, Session session) {


        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);


    }


}
