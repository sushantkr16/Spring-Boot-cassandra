package com.sk.learn.invitation.domain;

import com.datastax.driver.core.DataType;
import lombok.Data;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static org.springframework.cassandra.core.PrimaryKeyType.CLUSTERED;
import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

/**
 * Created by sk on 28/10/18.
 */
@Data
@Table("invitation")
public class Invitation {

    @PrimaryKeyColumn(name = "invitation_type", type = PARTITIONED)
    @CassandraType(type = DataType.Name.TEXT)
    private String invitationType;

    @PrimaryKeyColumn(name = "invitation_date", type = CLUSTERED)
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate invitationDate;

    @CassandraType(type = DataType.Name.UUID)
    @Column("invitation_id")
    private UUID invitationId;

    @CassandraType(type = DataType.Name.TEXT)
    @Column("invitation_message")
    private String invitationMessage;

    @CassandraType(type = DataType.Name.TEXT)
    @Column("invitation_to")
    private String invitationTo;

    @CassandraType(type = DataType.Name.TEXT)
    @Column("venue_address")
    private String venueAddress;

}
