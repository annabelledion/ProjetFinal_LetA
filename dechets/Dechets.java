package dechets;

import utile.AttXML;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class Dechets implements Comparable<Dechets>, Serializable{

    protected String type;
    protected int masseVol;
    protected int recyclage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMasseVol() {
        return masseVol;
    }

    public void setMasseVol(int masseVol) {
        this.masseVol = masseVol;
    }

    public int getRecyclage() {
        return recyclage;
    }

    public void setRecyclage(int recyclage) {
        this.recyclage = recyclage;
    }

    @Override
    public int compareTo(Dechets o) {
        return masseVol - o.getMasseVol();
    }
}
