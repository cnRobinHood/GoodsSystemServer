package servlets;

import net.sf.json.JSONObject;
import services.AdminInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminInfoServlet extends HttpServlet {
    private AdminInfoService adminInfoService = new AdminInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String uname = req.getParameter("uname");
        if ("1".equals(type)) {
            JSONObject object = JSONObject.fromObject(adminInfoService.getAdminINfo(uname));
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().print(object.toString());
        } else if ("2".equals(type)) {
            String passwd = req.getParameter("passwd");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().print(adminInfoService.verifyCount(uname, passwd));
        } else if ("3".equals(type)) {
            String passwd = req.getParameter("passwd");
            adminInfoService.setAdminInfo(uname, passwd);
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().print("true");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
