package com.study.model.pojo.power;

import java.util.List;

public class Module {
    private Integer moduleId;
    private String moduleName;
    private String moduleUrl;
    private String moduleIcon;
    private String moduleComponent;
    private List<RoleModule> roleModule;
    private List<Module> children;
    private Module module;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }


    public String getModuleIcon() {
        return moduleIcon;
    }

    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }


    public String getModuleComponent() {
        return moduleComponent;
    }

    public void setModuleComponent(String moduleComponent) {
        this.moduleComponent = moduleComponent;
    }


    public List<RoleModule> getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(List<RoleModule> roleModule) {
        this.roleModule = roleModule;
    }


    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
