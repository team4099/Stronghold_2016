/*
 * Vision subsystem - communicates with the external processor for actual data
 */
import java.util.ArrayList;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Interface to integrate with external imaging processing 
 */
class VisionDataSystem
{
    public static void main(String args[]) {
        VisionDataSystem test = new VisionDataSystem(.2f);
        test.updateVisionData();
        System.out.printf("LA %f \nFA %f\nVA %f\n", test.getLateralAngle(), test.getFiringAcceleration(), test.getVerticalAngle());
    }
    private String ip = "127.0.0.1";
    private int port = 5802;

    private int acquiredTarget;
    private float verticalAngle, firingAcceleration, lateralAngle;

    private Socket processorSocket;

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
        try {
            this.processorSocket = new Socket(this.ip, this.port);
            
            BufferedReader stdout = new BufferedReader(new InputStreamReader(processorSocket.getInputStream()));
            String serverResponse = stdout.readLine();
            System.out.println(serverResponse);
            String[] statArgs = serverResponse.split(",");

            /* 
             * Can't update data if the data doesn't exist - maybe we should set
             * the args to a null value or throw an exception when there isn't anything to shoot? 
             */
            if (statArgs[0].equals("0")) {
                this.acquiredTarget = 0;
            } else if (statArgs[0].equals("1")){
                this.acquiredTarget = 1;
                this.lateralAngle = Integer.parseInt(statArgs[3]);
            } else if (statArgs[0].equals("2")) { 
                this.acquiredTarget = 2;
                this.verticalAngle = Integer.parseInt(statArgs[1]);
                this.firingAcceleration = Integer.parseInt(statArgs[2]);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Returns true if the bot is in range to land a shot
     */
    public int getTargetAcquired() {
        return this.acquiredTarget;
    }

    /*
     * Returns the lateral angle the bot/shooter must rotate laterally to land the shot
     */
    public float getLateralAngle() {
        return this.lateralAngle;
    }

    /*
     * Returns the vertical angle the shooting arm must be in to land the shot
     */
    public float getVerticalAngle() {
        return this.verticalAngle;
    }

    /*
     * Return the acceleration the shooter must shoot at to land the shot
     */
    public float getFiringAcceleration() {
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


