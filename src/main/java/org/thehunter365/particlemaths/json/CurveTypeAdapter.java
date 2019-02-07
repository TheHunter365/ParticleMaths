package org.thehunter365.particlemaths.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.thehunter365.particlemaths.math.Curve;
import org.thehunter365.particlemaths.math.ParametricEquation;

import java.io.IOException;

public class CurveTypeAdapter extends TypeAdapter<Curve> {


    /*
    public abstract int duration();

    public abstract int loopPerTicks();

    public abstract double timeInc();


     */

    @Override
    public void write(JsonWriter writer, Curve curve) throws IOException {

        writer.beginObject();
            writer.name("duration").value(curve.duration());
            writer.name("loopPerTicks").value(curve.loopPerTicks());
            writer.name("timeIncrement").value(curve.timeInc());

        ParametricEquation curveEquation = curve;
        //WIP, need an equation parser :(
            //WIP
        writer.endObject();

    }

    @Override
    public Curve read(JsonReader reader) throws IOException {

        return null;
    }
}
