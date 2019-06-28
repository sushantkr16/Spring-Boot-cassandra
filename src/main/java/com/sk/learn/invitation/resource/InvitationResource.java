package com.sk.learn.invitation.resource;

import com.sk.learn.invitation.domain.InvitationRequest;
import com.sk.learn.invitation.domain.InvitationResponse;
import com.sk.learn.invitation.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by sk on 28/10/18.
 */

@RestController
@RequestMapping("/invitation")
public class InvitationResource {

    @Autowired
    InvitationService invitationService;

    @PostMapping
    public ResponseEntity createBirthdayInvitation(@RequestBody InvitationRequest invitationRequest) {

        InvitationResponse invitationResponse = invitationService.createInvitation(invitationRequest);

        if (null != invitationResponse) {
            return new ResponseEntity(invitationResponse, OK);
        } else {
            return new ResponseEntity("Issue while writing invitationRequest message", BAD_REQUEST);
        }
    }

    @GetMapping("/{invitationId}")
    public ResponseEntity getBirthdayInvitation(@PathVariable String invitationId) {

        InvitationResponse invitationResponse = invitationService.getInvitation(invitationId);

        if (null != invitationResponse) {
            return new ResponseEntity(invitationResponse, OK);
        } else {
            return new ResponseEntity("No invitation exists", BAD_REQUEST);
        }
    }

    @GetMapping("all")
    public ResponseEntity getAllBirthdayInvitation() {

        List<InvitationResponse> invitationResponseList = invitationService.getAllInvitations();

        if (null != invitationResponseList) {
            return new ResponseEntity(invitationResponseList, OK);
        } else {
            return new ResponseEntity("No invitation exists", BAD_REQUEST);
        }
    }

}
