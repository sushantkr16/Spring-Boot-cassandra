package com.sk.learn.invitation.service;

import com.sk.learn.invitation.domain.InvitationRequest;
import com.sk.learn.invitation.domain.InvitationResponse;

/**
 * Created by sk on 28/10/18.
 */
public interface InvitationService {

    InvitationResponse createInvitation(InvitationRequest invitationRequest);
    InvitationResponse getInvitation(String invitationId);
}
