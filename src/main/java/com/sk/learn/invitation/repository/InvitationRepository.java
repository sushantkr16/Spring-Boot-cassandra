package com.sk.learn.invitation.repository;

import com.sk.learn.invitation.domain.Invitation;
import com.sk.learn.invitation.domain.InvitationResponse;

public interface InvitationRepository {

    Invitation createInvitation(Invitation invitation);
    Invitation getInvitation(String invitationId);
}
