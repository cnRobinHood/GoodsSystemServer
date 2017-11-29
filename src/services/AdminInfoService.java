package services;

import dao.AdminInfoDao;
import entities.AdminInfo;

public class AdminInfoService {
    AdminInfoDao adminInfoDao = new AdminInfoDao();

    public boolean verifyCount(String username, String passwd) {
        if (passwd.equals(adminInfoDao.getPassword(username))) {
            return true;
        } else return false;
    }

    public AdminInfo getAdminINfo(String username) {
        return adminInfoDao.getAdminInfo(username);
    }

    public void setAdminInfo(String username, String passwd) {
        adminInfoDao.setAdminInfo(username, passwd);
    }
}
