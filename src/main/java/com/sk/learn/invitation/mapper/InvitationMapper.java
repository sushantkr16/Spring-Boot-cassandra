package com.sk.learn.invitation.mapper;


import com.sk.learn.invitation.domain.Invitation;
import com.sk.learn.invitation.domain.InvitationRequest;
import com.sk.learn.invitation.domain.InvitationResponse;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InvitationMapper {

    public static Invitation toDomainFromRequest(InvitationRequest invitationRequest) {
        if (null != invitationRequest) {
          Invitation invitation = new Invitation();
          invitation.setInvitationType(invitationRequest.getInvitationType());
          invitation.setInvitationDate(LocalDate.parse(invitationRequest.getInvitationDate()));
          invitation.setInvitationMessage(invitationRequest.getInvitationMessage());
          invitation.setInvitationTo(invitationRequest.getInvitationTo());
          invitation.setVenueAddress(invitationRequest.getVenueAddress());
          return invitation;
        }
        return null;
    }

    public static InvitationResponse toResponseFromDomain(Invitation invitation) {
        if (null != invitation) {
            InvitationResponse invitationResponse = new InvitationResponse();
            invitationResponse.setInvitationId(invitation.getInvitationId());
            invitationResponse.setInvitationType(invitation.getInvitationType());
            invitationResponse.setInvitationDate(
                    invitation.getInvitationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            invitationResponse.setInvitationMessage(invitation.getInvitationMessage());
            invitationResponse.setInvitationTo(invitation.getInvitationTo());
            invitationResponse.setVenueAddress(invitation.getVenueAddress());
            return invitationResponse;
        }

        return null;

    }

    public static List<InvitationResponse> toResponseListFromDomain(List<Invitation> invitationList) {
        List<InvitationResponse> invitationResponseList = null;
        if (!CollectionUtils.isEmpty(invitationList)) {
            invitationResponseList = new ArrayList<>();
            for (Invitation invitation: invitationList) {
                InvitationResponse invitationResponse = new InvitationResponse();
                invitationResponse.setInvitationId(invitation.getInvitationId());
                invitationResponse.setInvitationType(invitation.getInvitationType());
                invitationResponse.setInvitationDate(
                        invitation.getInvitationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                invitationResponse.setInvitationMessage(invitation.getInvitationMessage());
                invitationResponse.setInvitationTo(invitation.getInvitationTo());
                invitationResponse.setVenueAddress(invitation.getVenueAddress());
                invitationResponseList.add(invitationResponse);
            }
        }
        return invitationResponseList;
    }
}