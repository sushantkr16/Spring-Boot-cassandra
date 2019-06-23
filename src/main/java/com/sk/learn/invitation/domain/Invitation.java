package com.sk.learn.invitation.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

/**
 * Created by sk on 28/10/18.
 */

@Table("invitation")
public class Invitation {

    @PrimaryKeyColumn(name = "invitation_id", type = PARTITIONED)
    @CassandraType(type = DataType.Name.TEXT)
    private String invitationId;

    @CassandraType(type = DataType.Name.TEXT)
    private String message;

    @CassandraType(type = DataType.Name.DATE)
    private Date date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
