package com.example.meepmeeptesting.Paths;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class AllStar {
  MeepMeep meepMeep = new MeepMeep(800);

  Pose2d startingPosition = new Pose2d(12, -64, 0);
  Pose2d allianceShippingHub = new Pose2d(-12, -42, Math.toRadians(90));

  Pose2d spinner = new Pose2d(-52, -64, Math.toRadians(90));
  Pose2d wareHouseP1 = new Pose2d(-40, -64, Math.toRadians(0));
  Pose2d wareHouseP2 = new Pose2d(38, -64, Math.toRadians(0));

  public RoadRunnerBotEntity bot =
      new DefaultBotBuilder(meepMeep)
          .setConstraints(40, 37, 13.241691158998306, Math.toRadians(214.92695399999997), 10)
          .setDimensions(13.5, 15.5)
          .followTrajectorySequence(
              drive ->
                  drive
                      .trajectorySequenceBuilder(startingPosition)
                      .addDisplacementMarker(
                          () -> {
                            // Subir El Brazo
                          })
                      .lineToSplineHeading(allianceShippingHub)
                      .addDisplacementMarker(
                          () -> {
                            // Escupir Game Piece
                          })
                      .lineToSplineHeading(startingPosition)
                      .addDisplacementMarker(
                          () -> {
                            // Bajar Brazo a MEDIUM
                          })
                      .build());
}
