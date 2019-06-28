CREATE KEYSPACE invitation WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE IF NOT EXISTS invitation.invitation (
   invitation_type text,
   invitation_id uuid,
   invitation_date date,
   invitation_message text,
   invitation_to text,
   venue_address text,
   primary key(invitation_type)
);




