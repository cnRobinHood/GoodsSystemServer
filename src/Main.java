import net.sf.json.JSONObject;
import services.AdminInfoService;

public class Main {
    public static void main(String[] args) {
//        Connection connection;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.
//                    getConnection("jdbc:mysql://127.0.0.1/GoodsSellSystem?unicode=true&characterEncoding=UTF-8","root","1154119523");
//            PreparedStatement statement = connection.prepareStatement
//                    ("INSERT INTO clothInfo (ID, Kinds, Lining, Season, Size) VALUES (?,?,?,?,?);");
//            statement.setString(1, "EP2015010039");
//            statement.setString(2, "风衣");
//            statement.setString(3, "毛线");
//            statement.setString(4, "秋季");
//            statement.setString(5, "XL");
//            statement.executeUpdate();
//            statement.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            AdminInfo adminInfo = new AdminInfo();
//            adminInfo.setFoucs("衣服");
//            adminInfo.setUsername("刘程");
//            adminInfo.setPhoneNum("110");
//            adminInfo.setPsword("100");
//            session.save(adminInfo);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//
//        }
        AdminInfoService adminInfoService = new AdminInfoService();
//        System.out.println(service.verifyCount("刘程","100"));
        JSONObject object = JSONObject.fromObject(adminInfoService.getAdminINfo("lc"));
        System.out.println(object.toString());

    }
}
