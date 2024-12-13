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
            // �����е�State��Ϊtrue����ת��fuxuan.jsp
            response.sendRedirect("secselected.jsp");
        } else {
            // ������һ��State��Ϊtrue�����������
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(
                "<script type='text/javascript'>" +
                "alert('��ѡ�׶�δ����');" +
                "history.back();" + // ���˵���һ��ҳ��
                "</script>"
            );
        }
    }
}
