package org.firstinspires.ftc.teamcode.Robots.Vinz.TeleOperated;

import static org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration.Mechanisms.armConfig;
import static org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration.Mechanisms.intakeConfig;
import static org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration.Mechanisms.manipulatorConfig;
import static org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration.Mechanisms.mecanumConfig;
import static org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration.Mechanisms.spinnerConfig;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Core.BaseClasses.OperationModes.EctoOpMode;
import org.firstinspires.ftc.teamcode.Mechanisms.Arm.Arm;
import org.firstinspires.ftc.teamcode.Mechanisms.Chassis.Mecanum.Mecanum;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Manipulator.Manipulator;
import org.firstinspires.ftc.teamcode.Mechanisms.Spinner.Spinner;
import org.firstinspires.ftc.teamcode.Robots.Vinz.Configuration;

@TeleOp(name = "TeleOperated")
public class TeleOperated extends EctoOpMode {

  // Mechanisms
  Mecanum chassis;
  Manipulator manipulator;
  Arm arm;
  Intake intake;
  Spinner spinner;

  // Controllers
  public static GamepadEx driverGamepad;
  public static GamepadEx manipulatorGamepad;

  @Override
  public void initRobotClasses() {

    // Controllers
    manipulatorGamepad = new GamepadEx(gamepad2);
    driverGamepad = new GamepadEx(gamepad1);

    // Mechanisms
    chassis = new Mecanum("ChassisMecanum", "Mechanism", mecanumConfig);
    arm = new Arm("arm", "Mechanism", armConfig);
    manipulator = new Manipulator("Manipulator", "Mechanism", manipulatorConfig);
    intake = new Intake("intake", "Mechanism", intakeConfig);
    spinner = new Spinner("spinner", "Mechanism", spinnerConfig);
  }

  @Override
  public void initRobot() {
    mechanismManager.addMechanism(chassis);
    mechanismManager.addMechanism(manipulator);
    mechanismManager.addMechanism(arm);
    mechanismManager.addMechanism(intake);
    mechanismManager.addMechanism(spinner);
  }

  @Override
  public void startRobot() {}

  @Override
  public void updateRobot(Double timeStep) {

    //////////////////////////
    //////// Chassis /////////
    //////////////////////////

    if (driverGamepad.getLeftY() != 0
        || driverGamepad.getLeftX() != 0
        || driverGamepad.getRightX() != 0) {
      chassis.setChassisMovement(
          driverGamepad.getLeftX() * -1,
          driverGamepad.getLeftY() * -1,
          driverGamepad.getRightX() * -1,
          Mecanum.orientation.field);
    } else {
      chassis.stopChassis();
    }

    /////////////////////////
    ////// Manipulator //////
    /////////////////////////

    //
    // Arm
    //
    if (manipulatorGamepad.getButton(Configuration.Buttons.y)) {
      arm.setPosition(300);
    }

    if (manipulatorGamepad.getButton(Configuration.Buttons.b)) {
      arm.setPosition(150);
    }

    if (manipulatorGamepad.getButton(Configuration.Buttons.a)) {
      arm.setPosition(75);
    }

    if (manipulatorGamepad.getButton(Configuration.Buttons.x)) {
      arm.setHomePosition();
    }

    if (manipulatorGamepad.getButton(Configuration.Buttons.start)) {
      arm.resetHomePosition();
    }

    if (manipulatorGamepad.getLeftY() != 0) {
      manipulator.turnOn(manipulatorGamepad.getLeftY());
    } else {
      manipulator.turnOff();
    }

    if (manipulatorGamepad.getRightY() != 0) {
      intake.turnOn(manipulatorGamepad.getRightY());
    } else {
      intake.turnOff();
    }

    if (manipulatorGamepad.getTrigger(Configuration.Buttons.leftTrigger) != 0) {
      spinner.turnOn(manipulatorGamepad.getTrigger(Configuration.Buttons.leftTrigger));
    } else {
      spinner.turnOff();
    }

    if (manipulatorGamepad.getTrigger(Configuration.Buttons.rightTrigger) != 0) {
      spinner.turnOn(manipulatorGamepad.getTrigger(Configuration.Buttons.rightTrigger) * -1);
    } else {
      spinner.turnOff();
    }

    telemetry.addData("arm", arm.getActualPosition());
    telemetry.update();
  }
}
