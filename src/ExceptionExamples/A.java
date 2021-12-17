package ExceptionExamples;

public class A {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            i = 3;
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            int z = 0;
            RobotConnection robotConnection = null;
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
            } catch (RobotConnectionException robotConnectionException) {
                z++;
            } catch (Exception e) {
                z++;
                throw e;
            } finally {
                try {
                    robotConnection.close();
                } catch (Exception e) {

                }
            }
            if (z == 0) {
                return;
            }
        }
        throw new RobotConnectionException("d");

    }
}
