package org.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {
    private List<Operator> operators;
    private List<Supervisor> supervisors;
    private List<Director> directors;
    private Queue<Call> callQueue;

    CallCenter() {
        operators = new ArrayList<>();
        supervisors = new ArrayList<>();
        directors = new ArrayList<>();
        callQueue = new LinkedList<>();
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public void addSupervisor(Supervisor supervisor) {
        supervisors.add(supervisor);
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void dispatchCall(Call call) {
        Employee emp = this.getAvailableEmployee();

        if (emp != null) {
            emp.setCall(call);
            call.setEmployee(emp);
            System.out.println("Successfully assigned this call to " + emp.getName());
        } else {
            System.out.println("No one is free right now!!!, Adding to queue. Please wait for some times");
            callQueue.add(call);
        }

    }

    public void completeCall(Call call) {
        System.out.println(call.getEmployee().getName() + "handled call from " + call.getCaller());
        call.getEmployee().setCall(null);
        call.setEmployee(null);
    }

    public Employee getAvailableEmployee() {

        //Check if any operator is free
        Employee emp = getAvailableOperator();
        if (emp != null)
            return emp;

        //Check if any supervisor is free
        emp = getAvailableSupervisor();
        if (emp != null)
            return emp;

        //Check if any director is free
        return getAvailableDirector();

    }

    public void escalateCall(Call call) {
        //Check the current rank
        if (call.getEmployee().getRank() == Rank.OPERATOR) {
            Employee emp = getAvailableSupervisor();
            if (emp == null)
                emp = getAvailableDirector();
            if (emp == null) {
                System.out.println("Please try after some time as no one is free right now");
            } else {
                call.setEmployee(emp);
                emp.setCall(call);
                System.out.println("Escalated call from " + call.getCaller() + " to " + emp.getName());
            }
        } else if (call.getEmployee().getRank() == Rank.SUPERVISOR) {
            Employee emp = getAvailableDirector();

            if (emp == null) {
                System.out.println("Please try after some time as no one is free right now");
            } else {
                call.setEmployee(emp);
                emp.setCall(call);
            }
        } else if (call.getEmployee().getRank() == Rank.DIRECTOR) {
            System.out.println("Can't escalate from director level!!!");
        } else {
            System.out.println("dispatch first!!!");
        }
    }

    public void processCallQueue() {
        while (!callQueue.isEmpty()) {
            Call call = callQueue.poll();
            this.dispatchCall(call);
        }
    }

    private Employee getAvailableOperator() {
        for (Operator operator : this.operators) {
            if (operator.getCall() == null)
                return operator;
        }
        return null;
    }

    private Employee getAvailableSupervisor() {
        for (Supervisor supervisor : this.supervisors) {
            if (supervisor.getCall() == null)
                return supervisor;
        }
        return null;
    }

    private Employee getAvailableDirector() {
        for (Director director : this.directors) {
            if (director.getCall() == null)
                return director;
        }
        return null;
    }
}
