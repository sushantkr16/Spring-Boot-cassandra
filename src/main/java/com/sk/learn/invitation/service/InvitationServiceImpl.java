package com.sk.learn.invitation.service;

import com.sk.learn.invitation.domain.Invitation;
import com.sk.learn.invitation.domain.InvitationRequest;
import com.sk.learn.invitation.domain.InvitationResponse;
import com.sk.learn.invitation.mapper.InvitationMapper;
import com.sk.learn.invitation.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by sk on 28/10/18.
 */
@Service
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    InvitationRepository invitationRepository;

    @Override
    public InvitationResponse createInvitation(InvitationRequest invitationRequest) {

        // map request to domain
        Invitation invitationDomain = InvitationMapper.toDomainFromRequest(invitationRequest);
        invitationDomain.setInvitationId(UUID.randomUUID());

        Invitation updatedInvitationRequest = invitationRepository.createInvitation(invitationDomain);

        // map domain to response
        InvitationResponse invitationResponse = InvitationMapper.toResponseFromDomain(updatedInvitationRequest);
        return invitationResponse;
    }

    @Override
    public InvitationResponse getInvitation(String invitationId) {
        Invitation requestedInvitation = invitationRepository.getInvitation(invitationId);

        // map domain to response
        InvitationResponse invitationResponse = InvitationMapper.toResponseFromDomain(requestedInvitation);
        return invitationResponse;
    }

    @Override
    public List<InvitationResponse> getAllInvitations() {
        List<Invitation> requestedInvitationList = invitationRepository.getAllInvitation();

        // map domain to response
        List<InvitationResponse> invitationResponseList = InvitationMapper.toResponseListFromDomain(requestedInvitationList);
        return invitationResponseList;
    }

}
