package Command;

public abstract class Command {

    protected Robot robot;

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public abstract void execute();
}

class moveForwardCommand extends Command {

    int space;

    public moveForwardCommand(int space) {
        this.space = space;
    }

    @Override
    public void execute() {
        robot.moveForward(space);
    }
}

class turnCommand extends Command {

    Robot.Direction direction;

    public turnCommand(Robot.Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        robot.turn(direction);
    }
}

class pickupCommand extends Command {

    @Override
    public void execute() {
        robot.pickup();
    }
}