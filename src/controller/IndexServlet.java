package controller;

import entity.*;
import mappers.CatalogMapper;
import mappers.LoginMapper;
import mappers.PublicityMapper;
import mappers.TeacherIndexMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get resource " + resource, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHomePage(request, response);
                break;
            case "login":
            	 handleLogin(request, response);
                break;
            case "catalog":
                showCatalogPage(request, response);
                break;
            case "publicity":
                showPublicityPage(request, response);
                break;
            default:
                showHomePage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            handleLogin(request, response);
        } else {
            doGet(request, response); // Delegate to doGet for other actions
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            LoginMapper lm = session.getMapper(LoginMapper.class);
            boolean hasInput = loginId != null && !loginId.trim().isEmpty() && password != null && !password.trim().isEmpty();
            if (hasInput) {
                Login login = lm.findLoginByLoginIdAndPassword(loginId, password);
                if (login != null) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("user", login.getLoginId());
                    if ("186".equals(loginId)) { // 假设管理员账号为186
                    	TeacherIndexMapper teacherIndexMapper=session.getMapper(TeacherIndexMapper.class);
            			List<TeacherIndex> teacherIndexs=teacherIndexMapper.selectAll();
            			request.getSession().setAttribute("teacherIndexs",teacherIndexs);
            			session.commit();
            			for(TeacherIndex a:teacherIndexs) {
            				System.out.println(a.getTN());
            			}
                        response.sendRedirect("administor.jsp");
                    } else {
                    	httpSession.setAttribute("tno", login.getLoginId());
                        response.sendRedirect("TutorPage.jsp");
                    }
                } else {
                    request.setAttribute("error", "用户名或密码错误！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "用户名或密码不能为空，请重新输入！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } finally {
            session.close();
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    private void showCatalogPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CatalogMapper cm = session.getMapper(CatalogMapper.class);
            List<Catalog> catalogList = cm.selectAll();
            request.setAttribute("catalogList", catalogList);
            request.getRequestDispatcher("catalog.jsp").forward(request, response);
        } finally {
            session.close();
        }
    }

    private void showPublicityPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PublicityMapper pm = session.getMapper(PublicityMapper.class);
            List<Publicity> publicityList = pm.selectAll();
            request.setAttribute("publicityList", publicityList);
            request.getRequestDispatcher("publicity.jsp").forward(request, response);
        } finally {
            session.close();
        }
    }
}