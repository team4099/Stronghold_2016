/*
 * Vision subsystem - communicates with the external processor for actual data
 */
import java.util.ArrayList;
import java.net.Socket;

/*
 * Interface to integrate with external imaging processing 
 */
class VisionDataSystem
{
    private String ip;
    private int port;

    private boolean acquiredTarget;
    private float targetDepth;

    private ArrayList<Command> commandQueue;

    /*
     * Period is the update interval 
     */
    public VisionDataSystem(float period) {
        this.commandQueue = new ArrayList<Command>();
    }

    /* 
     * Everytime this command is called, method checks for new vision data from 
     * the vision processor and sends any queued commands to the vision processor
     * */ 
    public void updateVisionData() {

    }
    
    public boolean targetAcquired() {
        return this.acquiredTarget;
    }
    public float getDepth() {
        return this.targetDepth;
    }
    
    public void queueCommand(Command cmd) {
        commandQueue.add(cmd);
    }
}

/* 
 * Command class - contains information about commands to transmit to the onboard processor
 * Currently undefined - uncertain what types of commands we will actually use 
 */
class Command
{
    private int cameraNum;
    public Command(int cameraNum) 
    {
        this.cameraNum = cameraNum;
    }
}


