package manager;

import db.DBConnectionProvider;
import model.Task;

import java.sql.*;
import java.text.SimpleDateFormat;

public class TaskManager {


    String date = "yyyy-MM-DD";
    SimpleDateFormat sdf = new SimpleDateFormat(date);
    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public boolean addTask(Task task) {
        String sql = "INSERT INTO task_manager.task('task_name','description','deadline','status','user_id')" + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getDescription());
            statement.setString(3, sdf.format(task.getDeadline()));
            statement.setString(4, String.valueOf(task.getStatus()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteTaskById(int id) {
        String sql = "DELETE FROM task_manager.task WHERE ID =" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}