package com.sk.learn.invitation.mapper;

import com.sk.learn.invitation.domain.Invitation;
import com.sk.learn.invitation.domain.InvitationRequest;
import com.sk.learn.invitation.domain.InvitationResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InvitationMapper {

    public static Invitation toDomainFromRequest(InvitationRequest invitationRequest) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (null != invitationRequest) {
            try {
              Invitation invitation = new Invitation();
              invitation.setDate(formatter.parse(invitationRequest.getInvitationDate()));
              invitation.setMessage(invitationRequest.getInvitationMessage());
              return invitation;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static InvitationResponse toResponseFromDomain(Invitation invitation) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (null != invitation) {
            InvitationResponse invitationResponse = new InvitationResponse();
            invitationResponse.setMessage(invitation.getMessage());
            invitationResponse.setDate(formatter.format(invitation.getDate()));
            return invitationResponse;
        }

        return null;

    }


}
