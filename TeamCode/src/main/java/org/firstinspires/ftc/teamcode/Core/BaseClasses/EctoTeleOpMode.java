//
// Created by Neil Rodriguez 10/28/2021
//

package org.firstinspires.ftc.teamcode.Core.BaseClasses;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.lang.annotation.Annotation;

abstract public class EctoTeleOpMode implements TeleOp {
    @Override

    public String name() {
        return null;
    }

    @Override
    public String group() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }


}
