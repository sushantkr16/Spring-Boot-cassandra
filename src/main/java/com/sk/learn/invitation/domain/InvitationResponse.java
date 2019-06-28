package com.sk.learn.invitation.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
public class InvitationResponse {

    private UUID invitationId;
    private String invitationType;
    private String invitationDate;
    private String invitationMessage;
    private String invitationTo;
    private String venueAddress;

}
