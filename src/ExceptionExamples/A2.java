package ExceptionExamples;

public class A2 {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            int z = 0;
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
            } catch (RobotConnectionException robotConnectionException) {
                z++;
            } catch (Exception e) {
                z++;
                throw e;
            }
            if (z == 0) {
                return;
            }
        }
        throw new RobotConnectionException("d");

    }
}
