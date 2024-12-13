package controller;

import service.IsSelectedService;
import utils.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fuxuanCheck")
public class FuxuanCheck extends HttpServlet {
    private IsSelectedService isSelectedService = new IsSelectedService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean allSelected = isSelectedService.allSelected();
        if (allSelected) {
            // 所有行的State都为true，跳转到fuxuan.jsp
            response.sendRedirect("secselected.jsp");
        } else {
            // 至少有一行State不为true，弹出警告框
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(
                "<script type='text/javascript'>" +
                "alert('初选阶段未结束');" +
                "history.back();" + // 后退到上一个页面
                "</script>"
            );
        }
    }
}
