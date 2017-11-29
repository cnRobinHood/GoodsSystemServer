package servlets;

import services.RepertoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RepertoryServlet extends HttpServlet {
    RepertoryService repertoryService = new RepertoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "1":
                String addr = req.getParameter("addr");
                String size = req.getParameter("size");
                String id = req.getParameter("id");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().print(repertoryService.getClothCount(id, size, addr));
                break;
            case "2":
                addr = req.getParameter("addr");
                size = req.getParameter("size");
                id = req.getParameter("id");
                int count = Integer.parseInt(req.getParameter("count"));
                repertoryService.setRepertoryInfo(id, size, addr, count);
                break;
            case "3":
                addr = req.getParameter("addr");
                size = req.getParameter("size");
                id = req.getParameter("id");
                count = Integer.parseInt(req.getParameter("count"));
                repertoryService.setClothCount(id, size, addr, count);
                break;
            case "4":
                size = req.getParameter("size");
                id = req.getParameter("id");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().print(repertoryService.getClothCount(id, size));
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
