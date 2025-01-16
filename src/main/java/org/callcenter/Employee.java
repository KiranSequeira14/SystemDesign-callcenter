package org.callcenter;

public abstract class Employee {
    private String name;
    private Rank rank;
    private Call call;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Call getCall() {
        return call;
    }

    public Employee(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public void setCall(Call call) {
        this.call = call;
    }
}
