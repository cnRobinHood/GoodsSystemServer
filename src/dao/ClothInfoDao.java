package dao;

import entities.ClothInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.GetSessionFactory;

import java.util.List;

public class ClothInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    public List<ClothInfo> searchClothInfo(String kind, String page, int type) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        if (type == 0) {
            int begin = Integer.parseInt(page) * 3;
            int stop = (Integer.parseInt(page) + 1) * 3;
            String sql = "select clothInfo from ClothInfo clothInfo where clothInfo.kinds='" + kind + "'";
            List<ClothInfo> clothInfoList = session.createQuery
                    (sql).setFirstResult(begin).setMaxResults(3).list();
            System.out.println(sql);
            transaction.commit();
            session.close();
            return clothInfoList;
        } else if (type == 1) {
            int begin = Integer.parseInt(page) * 10;
            int stop = (Integer.parseInt(page) + 1) * 10;
            String sql = "select clothInfo from ClothInfo clothInfo where clothInfo.kinds='" + kind + "'";
            List<ClothInfo> clothInfoList = session.createQuery
                    (sql).setFirstResult(begin).setMaxResults(10).list();
            System.out.println(sql);
            transaction.commit();
            session.close();
            return clothInfoList;
        }
        return null;


    }
    public ClothInfo getClothInfo(String id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ClothInfo> clothInfoList = session.createQuery
                ("select clothInfo from ClothInfo clothInfo where clothInfo.id='" + id + "'").list();
        transaction.commit();
        session.close();
        return clothInfoList.get(0);
    }

    public void addClothInfo(String id, String kind, String lining, String season, String size, String image, String star) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        ClothInfo clothInfo = new ClothInfo();
        clothInfo.setID(id);
        clothInfo.setImages(image);
        clothInfo.setKinds(kind);
        clothInfo.setLining(lining);
        clothInfo.setSeason(season);
        clothInfo.setSize(size);
        clothInfo.setStars(star);
        session.save(clothInfo);
        transaction.commit();
        session.close();
    }
}
