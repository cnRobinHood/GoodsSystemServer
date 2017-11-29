package servlets;

import entities.ClothInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import services.ClothInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@MultipartConfig
public class ClothInfoServlet extends HttpServlet {
    ClothInfoService clothInfoService = new ClothInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type != null || !"".equals(type)) {
            switch (type) {
                case "1":
                    String count = req.getParameter("pages");
                    String kind = req.getParameter("kind");
                    String type1 = req.getParameter("type1");
                    ArrayList<ClothInfo> clothInfoArrayList = (ArrayList<ClothInfo>) clothInfoService.SearchClothinfo(kind, count, Integer.parseInt(type1));
                    JSONArray jsonArray = JSONArray.fromObject(clothInfoArrayList);
                    resp.setCharacterEncoding("utf-8");
                    resp.getWriter().print(jsonArray.toString());
                    break;
                case "2":
                    String id = req.getParameter("id");
                    JSONObject jsonObject = JSONObject.fromObject(clothInfoService.getClothInfo(id));
                    resp.setCharacterEncoding("utf-8");
                    resp.getWriter().print(jsonObject.toString());
                    break;
                case "3":
                    id = req.getParameter("id");
                    kind = req.getParameter("kind");
                    String star = req.getParameter("star");
                    String lining = req.getParameter("lining");
                    String season = req.getParameter("season");
                    String size = req.getParameter("size");
                    String image = req.getParameter("image");
                    clothInfoService.setClothInfo(id, kind, lining, season, size, image, star);
                    break;
                case "4":
                    String count1 = req.getParameter("pages");
                    String kind1 = req.getParameter("kind");
                    ArrayList<ClothInfo> clothInfoArrayList1 = (ArrayList<ClothInfo>) clothInfoService.SearchClothinfo(kind1, count1, 1);
                    JSONArray jsonArray1 = JSONArray.fromObject(clothInfoArrayList1);
                    System.out.println(jsonArray1.toString());
                    resp.setCharacterEncoding("utf-8");
                    resp.getWriter().print(jsonArray1.toString());
                    break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        String path = req.getSession().getServletContext().getRealPath("/") + "clothimages";
        System.out.println(req.getSession().getServletContext().getRealPath("/"));
        fileItemFactory.setRepository(new File(path));
        //  ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        Part filePart = req.getPart("file");
        try {
//            List<FileItem> items = upload.parseRequest(req);
//            FileItem item = items.get(0);
//            String filePath = item.getName();
//            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            InputStream in = filePart.getInputStream();
            FileOutputStream out = new FileOutputStream(new File(path, filePart.getSubmittedFileName()));
            int lengeh = 0;
            byte[] bytes = new byte[512];
            while ((lengeh = in.read(bytes)) != -1) {
                out.write(bytes, 0, lengeh);
            }
            in.close();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
