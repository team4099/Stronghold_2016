/*
 * Vision subsystem - communicates with the external processor for actual data
 */
import java.util.ArrayList;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

/*
 * Interface to integrate with external imaging processing 
 */
class VisionDataSystem
{
    private String ip;
    private int port;

    private boolean acquiredTarget;
    private float verticalAngle, firingAcceleration, lateralAngle;

    private Socket processorSocket;

    private ArrayList<Command> commandQueue;

    /*
     * Period is the update interval 
     */
    public VisionDataSystem(float period) {
        this.commandQueue = new ArrayList<Command>();
        try {
            this.processorSocket = new Socket(ip, port);
            /*
            In stdin = new In();
            Out stdout = new Out();
            */
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        }
    }

    /* 
     * Everytime this command is called, method checks for new vision data from 
     * the vision processor and sends any queued commands to the vision processor
     * */ 
    public void updateVisionData() {

    }
    
    /*
     * Returns true if the bot is in range to land a shot
     */
    public boolean targetAcquired() {
        return this.acquiredTarget;
    }

    /*
     * Returns the lateral angle the bot/shooter must rotate laterally to land the shot
     */
    public float lateralAngle() {
        return this.lateralAngle;
    }

    /*
     * Returns the vertical angle the shooting arm must be in to land the shot
     */
    public float verticalAngle() {
        return this.verticalAngle;
    }

    /*
     * Return the acceleration the shooter must shoot at to land the shot
     */
    public float firingAcceleration() {
        return this.firingAcceleration;
    }
    
    public void queueCommand(Command cmd) {
        commandQueue.add(cmd);
    }
}

/* 
 * Command class - contains information about commands to transmit to the onboard processor
 * Currently undefined - uncertain what types of commands we will actually use 
 *
 * We may not need this at all - this will allow us to do on-the-fly camera resetting if necessary
 */
class Command
{
    private int cameraNum;
    public Command(int cameraNum) 
    {
        this.cameraNum = cameraNum;
    }
}


