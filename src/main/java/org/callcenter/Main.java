package org.callcenter;

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        Director director1 = new Director("Aman");
        Supervisor supervisor1 = new Supervisor("Suman");
        Operator operator1 = new Operator("Me");
        Operator operator2 = new Operator("MyFriend");

        callCenter.addDirector(director1);
        callCenter.addSupervisor(supervisor1);
        callCenter.addOperator(operator1);
        callCenter.addOperator(operator2);

        //Call 1
        Call cal1 = new Call("caller1");
        callCenter.dispatchCall(cal1);

        //Call 2
        Call cal2 = new Call("caller2");
        callCenter.dispatchCall(cal2);

        //Call 3
        Call cal3 = new Call("caller3");
        callCenter.dispatchCall(cal3);


        //Call 4 -> should go to queue
//        Call cal4 = new Call("caller4");
//        callCenter.dispatchCall(cal4);

        //Try to escalate call1
        callCenter.escalateCall(cal1);
    }
}
