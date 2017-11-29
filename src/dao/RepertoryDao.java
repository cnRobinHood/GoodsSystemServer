package dao;

import entities.Repertory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.List;

public class RepertoryDao {
    SessionFactory factory = GetSessionFactory.getFactory();
    Session session = factory.openSession();

    public int getClothCount(String clothId, String size) {
        Transaction transaction = session.beginTransaction();
        List<Integer> count = session.createQuery
                ("select repertory.count from Repertory repertory where repertory.id='" + clothId + "'" + "and repertory.size='" + size + "'").list();
        transaction.commit();
        return count.get(0);
    }

    public int getClothCount(String clothId, String size, String addr) {
        Transaction transaction = session.beginTransaction();
        List<Integer> count = session.createQuery
                ("select repertory.count from Repertory repertory where repertory.id='" + clothId + "'" + "and repertory.size='" + size + "'" + "and repertory.addr='" + addr + "'").list();
        transaction.commit();
        return count.get(0);
    }

    public void setClothCount(String clothId, String size, String addr, int count) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery
                ("update Repertory repertory set repertory.count=" + count + "where repertory.id='" + clothId + "'" + " and repertory.addr='" + addr + "'" + " and repertory.size='" + size + "'");
        query.executeUpdate();
        transaction.commit();
    }

    public void setRepertoryInfo(String clothId, String size, String addr, int count) {
        Transaction transaction = session.beginTransaction();
        Repertory repertory = new Repertory();
        repertory.setAddr(addr);
        repertory.setCount(count);
        repertory.setId(clothId);
        repertory.setSize(size);
        session.save(repertory);
        transaction.commit();

    }
}
