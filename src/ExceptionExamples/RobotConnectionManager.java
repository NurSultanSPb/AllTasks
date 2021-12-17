package ExceptionExamples;
//За установку соединения отвечает RobotConnectionManager:
//Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение,
// через которое можно отдавать роботу команды.
public interface RobotConnectionManager {
    RobotConnection getConnection();
}
