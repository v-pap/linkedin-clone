package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="message_id")
	private int messageId;

	private byte read;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="from")
	private Professional professional1;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="to")
	private Professional professional2;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public byte getRead() {
		return this.read;
	}

	public void setRead(byte read) {
		this.read = read;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Professional getProfessional1() {
		return this.professional1;
	}

	public void setProfessional1(Professional professional1) {
		this.professional1 = professional1;
	}

	public Professional getProfessional2() {
		return this.professional2;
	}

	public void setProfessional2(Professional professional2) {
		this.professional2 = professional2;
	}

}