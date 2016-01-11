# Team 4099: FIRST Robotics Competition (FRC) Code

## Programmer Notes
0. Using the IntelliJ IDEA IDE to program the robot (not officially supported by FIRST)
1. Ant Build -> Add -> deploy (use the build.xml file)
2. Java + Intellij Basics
  * Classpath
    * Set of paths to directories and archives containing SDK binaries.
    * For the JDK, this includes paths to class directories and JAT files that make up the java API and its extensions
  * Sourcepath
    * Path to dirs and archives containing the source of the SDK binaries
    * Optional: helps with providing inline help
  * Documentation path
    * Allows for viewing of documentation

## Programmer TODOs
0. Consistently keep contact with the electrical and mechanical teams to understand what components are being used.
1. Read https://www.jetbrains.com/idea/help/essentials.html (learn about Java and building)
2. Read about every component that may be used on the robot (every electrical component)

## Code TODOs
### Autonomous
1. Vision processing
2. Gyro/navX processing to drive straight (navX if we have enough money)
3. Encoders for autonomous
4. BeagleBone Black (prob don't need this)

### Teleop
1. Best deadband code (deadband shape) to make driving easy for the operator
  * TMP + PID is for autonomous, with a pre-programmed path & trajectory -- see Team 254's code
2. Use gyro to correct for drift?
3. Set up the Gamepad class to encapsulate the joystick

### Disabled
1. Reload configuration constants from file

### Test
1. Create TestAutoMode to test each component

### General
1. Lights -- Have the lights controlled by the period (i.e. autonomous is one color, teleop is another, etc)
  * I2C Controller maybe..

## Code Organization and Breakdown

### org.usfirst.frc.team4099.robot
Default generated code from RobotBuilder software provided by WPIlib.

### org.usfirst.frc.team4099.robot.auto

### org.usfirst.frc.team4099.robot.commands

### org.usfirst.frc.team4099.robot.subsystems
Holds the abstracted subsystems for each designation portion of the robot. Helps with OOP.
* CommandBase.java
  * Holds a single instance of each subsystem (prevents multiple instances)

### org.usfirst.frc.team4099.robot.subsystems.controllers

### org.usfirst.frc.team4099.robot.triggers

### org.usfirst.frc.team4099.lib.util

