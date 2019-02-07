package org.thehunter365.particlemaths.data;

import org.thehunter365.particlemaths.json.JsonManager;
import org.thehunter365.particlemaths.math.Curve;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CurvesManager {

    private JsonManager jsonManager;
    private File curveFolder;

    private Map<String, Curve> curves;

    public CurvesManager(JsonManager jsonManager, File dataFolder) {

        this.curveFolder =  new File(dataFolder,
                "curves/");

        this.jsonManager = jsonManager;
        this.curves = new HashMap<>();

        curveFolder.getParentFile().mkdir();
        curveFolder.mkdir();
    }


    public void loadCurves() {
        File[] curves = this.curveFolder.listFiles();
        for (File file : this.curveFolder.listFiles()) {
            String fileName = file.getName();
            if (fileName.endsWith(".json")) {
                String json = loadFile(file);
                if (!json.equals("")) {
                    Curve curve = this.jsonManager.deserialize(
                            json,
                            Curve.class
                    );
                    this.curves.put(fileName.replace(".json", ""), curve);
                }

            }
        }
    }

    public Map<String, Curve> getCurves() {
        return curves;
    }

    public Curve getCruveByName(String curveName) {
        Map.Entry<String, Curve> curveEntry = this.curves.entrySet()
                .stream().filter(entry -> entry.getKey().equals(curveName)).findFirst().orElse(null);

        return curveEntry != null ? curveEntry.getValue() : null;
    }

    private String loadFile(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
