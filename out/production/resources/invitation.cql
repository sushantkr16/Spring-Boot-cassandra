CREATE KEYSPACE invitation WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE IF NOT EXISTS invitation.invitation (
    invitation_id uuid,
    message text,
    date text,
    primary key(invitation_id)
);




