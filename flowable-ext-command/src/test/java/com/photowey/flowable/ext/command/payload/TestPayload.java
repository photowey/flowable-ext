package com.photowey.flowable.ext.command.payload;

import java.io.Serializable;

/**
 * TestPayload
 *
 * @author photowey
 * @date 2020/12/20
 * @since 1.0.0
 */
public class TestPayload implements Serializable {
    private String candidateUser = "photowey";

    public TestPayload() {
    }

    public TestPayload(String candidateUser) {
        this.candidateUser = candidateUser;
    }

    public String getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(String candidateUser) {
        this.candidateUser = candidateUser;
    }
}
