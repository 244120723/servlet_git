package controller.admin;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet",urlPatterns = "/userDeleteServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数值
        String id = req.getParameter("userid");
        //根据id删除用户
        UserDao userDao=new UserDao();
        int row = userDao.deleteUserById(id);
        //对row判断
        if(row>0){
            //删除成功
            //重定向
            resp.sendRedirect("/userSelectServlet");
        }else{
            //删除失败,跳到出错页面
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}