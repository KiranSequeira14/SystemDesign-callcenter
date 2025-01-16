package org.callcenter;

public class Call {
    private String caller;
    private Employee employee;

    Call(String caller){
        this.caller = caller;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }
}
