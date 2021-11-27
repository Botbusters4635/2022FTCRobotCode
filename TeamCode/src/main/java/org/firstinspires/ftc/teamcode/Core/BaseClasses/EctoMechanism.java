//
// Created by Neil Rodriguez 10/28/2021
//

package org.firstinspires.ftc.teamcode.Core.BaseClasses;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Core.Managers.MechanismManager;
import org.firstinspires.ftc.teamcode.Core.Module;

public abstract class EctoMechanism extends Module {

    protected Telemetry telemetry;
    protected HardwareMap hardwareMap;

    public EctoMechanism(String moduleName, String moduleType) {
        super(moduleName, moduleType);
    }

    public void initMechanism(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
    }

    //Every mechanism should be able to do this functions
    public abstract void initMechanism();
    public abstract void startMechanism();
    public abstract void updateMechanism();
    public abstract void stopMechanism();
}