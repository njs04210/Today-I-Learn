package Command;

public class MyProgram {

    public static void main(String[] args) {

        RobotKit robotKit = new RobotKit();

        robotKit.addCommand(new moveForwardCommand(5));
        robotKit.addCommand(new turnCommand(Robot.Direction.RIGHT));
        robotKit.addCommand(new moveForwardCommand(2));
        robotKit.addCommand(new turnCommand(Robot.Direction.LEFT));
        robotKit.addCommand(new pickupCommand());

        robotKit.start();
    }
}
