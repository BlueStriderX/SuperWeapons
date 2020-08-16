package net.dovtech.superweapons.draw;

import org.schema.game.client.view.beam.BeamColors;
import org.schema.schine.graphicsengine.core.Drawable;
import javax.vecmath.Vector3f;

public class ReflectorBeamDrawer implements Drawable {

    private BeamColors color;
    private Vector3f pointA;
    private Vector3f pointB;

    public ReflectorBeamDrawer(Vector3f pointA, Vector3f pointB, BeamColors color) {
        this.color = color;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public void cleanUp() {

    }

    @Override
    public void draw() {

    }

    @Override
    public boolean isInvisible() {
        return false;
    }

    @Override
    public void onInit() {

    }
}
