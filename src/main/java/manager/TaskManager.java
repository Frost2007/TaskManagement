package manager;

import db.DBConnectionProvider;
import model.Task;
import model.TaskStatus;
import model.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {


    String date = "yyyy-MM-DD";
    SimpleDateFormat sdf = new SimpleDateFormat(date);
    Connection connection = DBConnectionProvider.getInstance().getConnection();
    UserManager userManager = new UserManager();

    public boolean addTask(Task task) {
        String sql = "INSERT INTO task_management.task (task_name,description,deadline,user_id)" + "VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getDescription());
            statement.setString(3, sdf.format(task.getDeadline()));
            statement.setInt(4, task.getUser().getId());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
            }
            return true;
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

    public List<Task> getTaskByUserId(User user) {
        String sql = "SELECT * FROM task_management.task WHERE user_id = ?";
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tasks.add(getTaskFromResultSet(resultSet));
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> getAllTasks() {
        String sql = "SELECT* FROM task_management.task ";
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tasks.add(getTaskFromResultSet(resultSet));
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Task getTaskFromResultSet(ResultSet resultSet) {
        try {
            return Task.builder()
                    .id(resultSet.getInt(1))
                    .taskName(resultSet.getString(2))
                    .description(resultSet.getString(3))
                    .deadline(sdf.parse(resultSet.getString(4)))
                    .status(TaskStatus.valueOf(resultSet.getString(5)))
                    .user(userManager.getUserById(resultSet.getInt(6)))
                    .build();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeTaskStatusById(int id, TaskStatus finished) {
        String sql = "UPDATE task_management.task SET status = 'FINISHED' WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Task getById(int id) {
        String sql = "SELECT * FROM task_management.task WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            return getTaskFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}