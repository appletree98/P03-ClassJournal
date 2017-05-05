package sg.edu.rp.c346.p03_classjournal;

/**
 * Created by 14056921 on 5/5/2017.
 */

public class Modules {
    private String moduleCode;
    private String moduleName;

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Modules(String moduleCode,String moduleName){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }
}
