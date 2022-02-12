package manager;

import DB.DBConnectionProvider;
import model.User;

import java.sql.*;

public class UserManager {

   private Connection connection = DBConnectionProvider.getInstance().getConnection();

   public boolean register(User user){
       String sql = "INSERT INTO user(name,surname,email,password,type) VALUES(?,?,?,?,?)";

       try {
           PreparedStatement statement= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, user.getName());
           statement.setString(2, user.getSurname());
           statement.setString(3, user.getEmail());
           statement.setString(4, user.getPassword());
           statement.setString(5,user.getType().toString());
           statement.executeUpdate();

           ResultSet rs = statement.getGeneratedKeys();
           if (rs.next()){
               user.setId(rs.getInt(1));
               return true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }

}
