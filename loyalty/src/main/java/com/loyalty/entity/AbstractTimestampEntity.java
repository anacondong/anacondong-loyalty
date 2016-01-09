package com.loyalty.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.loyalty.unity.DateUnity;

@MappedSuperclass
public abstract class AbstractTimestampEntity {
	
	
	@Column
	private boolean activeFlg;
	 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;
	
    @Column(name = "regDt")
    private String regDt;

    @Column(name = "chgDt")
    private String chgDt;

    @PrePersist
    protected void onCreate() {
    	regDt = DateUnity.getCurrentTimeStamp();
    	chgDt = DateUnity.getCurrentTimeStamp();
    }

    @PreUpdate
    protected void onUpdate() {
    	chgDt = DateUnity.getCurrentTimeStamp();
    	regDt = DateUnity.getCurrentTimeStamp();
    }
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getChgDt() {
		return chgDt;
	}

	public void setChgDt(String chgDt) {
		this.chgDt = chgDt;
	}

	public boolean isActiveFlg() {
		return activeFlg;
	}

	public void setActiveFlg(boolean activeFlg) {
		this.activeFlg = activeFlg;
	}
	
}