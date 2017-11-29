package dao;

import entities.AdminInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.GetSessionFactory;

import java.util.List;

public class AdminInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();


    public String getPassword(String a) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<String> passwordList = session.createQuery
                ("select admin.psword from AdminInfo admin where admin.username='" + a + "'").list();
        transaction.commit();
        session.close();
        return passwordList.get(0);
    }

    public AdminInfo getAdminInfo(String a) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<AdminInfo> adminInfoList = session.createQuery
                ("select admin from AdminInfo admin where admin.username='" + a + "'").list();
        transaction.commit();
        session.close();
        return adminInfoList.get(0);

    }

    public void setAdminInfo(String username, String password) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setUsername(username);
            adminInfo.setPsword(password);
            session.save(adminInfo);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }

    }
}
