/*
Starter Code for Quad Training Robot 2024
Modified by michaudc 2017, 2023, 2024
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="MaristBot2024: Quad Training 2024", group="Training")
//@Disabled
public class TeleopQuad_Training_2024 extends OpMode {

    // Create instance of MaristBaseRobot2024
    MaristBaseRobot2024_Quad robot   = new MaristBaseRobot2024_Quad();
    private Object rightFrontPower;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Robot Ready");    //

        // Set to Run without Encoder for Tele Operated
        robot.leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double leftX = gamepad1.left_stick_x;
        double leftY = gamepad1.left_stick_y;
        double rightX = gamepad1.right_stick_x;

        robot.driveStrafer(leftX, leftY, rightX);

        double leftArmPower = gamepad1.left_trigger - gamepad1.right_trigger;
        robot.leftArm.setPower(leftArmPower);

        if (gamepad1.a) {
            robot.rightArm.setPower(0.5);
        }
        else if (gamepad1.y) {
            robot.rightArm.setPower (-0.5);
        }
        else {
            robot.rightArm.setPower(0);
        }

        if (gamepad1.right_bumper) {
            robot.leftHand.setPosition(0.25);
        }
        if (gamepad1.left_bumper) {
            robot.leftHand.setPosition(0.75);
        }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}