package com.sk.learn.invitation.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by sk on 28/10/18.
 */

@Data
public class InvitationRequest {

    private String invitationType;
    private String invitationDate;
    private String invitationMessage;
    private String invitationTo;
    private String venueAddress;

}
