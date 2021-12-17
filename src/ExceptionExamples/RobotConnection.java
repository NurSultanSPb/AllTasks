package ExceptionExamples;
//RobotConnection - это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно.
// Для закрытия соединения в интерфейсе есть метод close().
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
