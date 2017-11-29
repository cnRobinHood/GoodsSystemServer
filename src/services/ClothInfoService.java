package services;

import dao.ClothInfoDao;
import entities.ClothInfo;

import java.util.List;

public class ClothInfoService {
    ClothInfoDao clothInfoDao = new ClothInfoDao();

    public List<ClothInfo> SearchClothinfo(String kind, String page, int type) {
        return clothInfoDao.searchClothInfo(kind, page, type);
    }

    public ClothInfo getClothInfo(String id) {
        return clothInfoDao.getClothInfo(id);
    }

    public void setClothInfo(String id, String kind, String lining, String season, String size, String image, String star) {
        clothInfoDao.addClothInfo(id, kind, lining, season, size, image, star);
    }
}
