package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15017519 on 5/5/2017.
 */

public class Journal implements Serializable {
    private String dgGrade;
    private String moduleCode;
    private int week;

    public Journal(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }
}
