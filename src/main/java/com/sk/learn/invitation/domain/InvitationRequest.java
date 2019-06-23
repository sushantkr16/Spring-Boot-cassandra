package com.sk.learn.invitation.domain;

/**
 * Created by sk on 28/10/18.
 */

//@Data
//lombok is not working. will integrate it later
public class InvitationRequest {

    private String invitationMessage;
    private String invitationDate;

    public String getInvitationMessage() {
        return invitationMessage;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }

    public String getInvitationDate() {
        return invitationDate;
    }

    public void setInvitationDate(String invitationDate) {
        this.invitationDate = invitationDate;
    }

}
