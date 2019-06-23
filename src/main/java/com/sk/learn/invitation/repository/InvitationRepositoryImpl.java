package com.sk.learn.invitation.repository;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.sk.learn.invitation.domain.Invitation;
import com.sk.learn.invitation.domain.InvitationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class InvitationRepositoryImpl implements InvitationRepository {

    @Autowired
    CassandraOperations cassandraOperations;

    @Override
    public Invitation createInvitation(Invitation invitation) {
        Invitation updatedInvitation = cassandraOperations.insert(invitation);
        return updatedInvitation;
    }

    @Override
    public Invitation getInvitation(String invitationId) {
        Select selectQuery = QueryBuilder.select().all().from("invitation", "invitation");
        Select.Where selectWhere = selectQuery.where();
        Clause clause = QueryBuilder.eq("invitationId", invitationId);
        selectWhere.and(clause);
        List<Invitation> invitationList = cassandraOperations.select(selectWhere.getQueryString(), Invitation.class);

        // We can handle it better
        if(!CollectionUtils.isEmpty(invitationList)) {
            return invitationList.get(0);
        } else {
            return null;
        }
    }
}
