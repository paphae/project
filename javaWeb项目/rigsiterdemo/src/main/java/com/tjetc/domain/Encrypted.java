package com.tjetc.domain;

import java.io.Serializable;

public class Encrypted implements Serializable {
    private Integer eid;
    private Integer uid;
    private String problem;
    private String answer;

    public Encrypted() {
    }

    public Encrypted(Integer uid, String problem, String answer) {
        this.uid = uid;
        this.problem = problem;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Encrypted{" +
                "eid=" + eid +
                ", uid=" + uid +
                ", problem='" + problem + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
