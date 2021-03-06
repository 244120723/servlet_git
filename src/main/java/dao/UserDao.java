package dao;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //封装一个方法根据管理员的名字查询管理员的信息
    public User selectAdminInfo(String name) {
        User user = null;
        Connection conn = DBUtil.getConn();
        String sql = "select * from tb_user where user_name=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                //取出数据的每个字段值
                Integer id = r.getInt("ID");
                String username = r.getString("USER_NAME");
                String pwd = r.getString("USER_PASSWORD");
                int userType = r.getInt("USER_TYPE");
                int userState = r.getInt("USER_STATE");
                //将取出的数据封装到对象
                user = new User();
                user.setId(id);
                user.setUserName(username);
                user.setUserPassword(pwd);
                user.setUserState(userState);
                user.setUserType(userType);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user;
    }

    //查询用户信息
    public List<User> userSelect(String id) throws SQLException {
        List<User> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        String sql = "";
        if (id == null || id.equals("")) {
            sql = "select * from tb_user";
        } else {
            sql = "select * from tb_user where id=" + id;
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet r = ps.executeQuery();
        //遍历结果集
        while (r.next()) {
            //取出数据的每个字段值
            Integer id1 = r.getInt("ID");
            String username = r.getString("USER_NAME");
            String pwd = r.getString("USER_PASSWORD");
            int userType = r.getInt("USER_TYPE");
            int userState = r.getInt("USER_STATE");
            //将取出的数据封装到对象
            User user = new User();
            user.setId(id1);
            user.setUserName(username);
            user.setUserPassword(pwd);
            user.setUserState(userState);
            user.setUserType(userType);
            list.add(user);
        }
        return list;
    }


    //根据id删除数据
    public int deleteUserById(String id) {
        int row = 0;
        //获取数据库连接
        Connection conn = DBUtil.getConn();
        //编写sql
        String sql = "delete from tb_user where id=?";
        //
        try {
            //创建PreparedStatement对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,Integer.parseInt(id));
            //执行
            row = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return row;
    }

    //根据id查询用户信息
    public User selectUserInfoById(String id){
        Connection conn = DBUtil.getConn();
        User user=null;
        String sql="select * from tb_user where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ResultSet r = ps.executeQuery();
            if(r.next()){
                //取出数据的每个字段值
                Integer id1 = r.getInt("ID");
                String username = r.getString("USER_NAME");
                String pwd = r.getString("USER_PASSWORD");
                int userType = r.getInt("USER_TYPE");
                int userState = r.getInt("USER_STATE");
                //将取出的数据封装到对象
                user = new User();
                user.setId(id1);
                user.setUserName(username);
                user.setUserPassword(pwd);
                user.setUserState(userState);
                user.setUserType(userType);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
            return user;
    }

    //根据id修改用户信息
    public int updateUserInfoById(User user){
        int row = 0;
        Connection conn = DBUtil.getConn();
        //编写sql
        String sql="update tb_user set user_password=? where id=?";
        //得到PreparedStatement对象
        //得到PreparedStatement对象
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            //给问号赋值
            ps.setString(1,user.getUserPassword());
            ps.setInt(2,user.getId());
            //执行
            row = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return row;
    }
}
