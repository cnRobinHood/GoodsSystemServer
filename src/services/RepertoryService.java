package services;

import dao.RepertoryDao;

public class RepertoryService {
    RepertoryDao repertoryDao = new RepertoryDao();

    public int getClothCount(String clothId, String size) {
        return repertoryDao.getClothCount(clothId, size);
    }

    public int getClothCount(String clothId, String size, String addr) {
        return repertoryDao.getClothCount(clothId, size, addr);
    }

    public void setClothCount(String clothId, String size, String addr, int count) {
        repertoryDao.setClothCount(clothId, size, addr, count);
    }

    public void setRepertoryInfo(String clothId, String size, String addr, int count) {
        repertoryDao.setRepertoryInfo(clothId, size, addr, count);
    }

}
