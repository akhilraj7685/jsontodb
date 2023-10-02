package com.ak.pojo;

import java.io.Serializable;
import java.util.Set;

public class EntryRecord implements Serializable {
	 private String id;
	 private String partyname;
	 private String buyergstno;
	 private String invno;
	 private String buyeraddress;
	 private String invhsn;
	 private String invdate;
	 private String invtotal;
	 private String amtinwords;
	 private Set<EntryRecordDetail> entry_record_detail;
	 public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getBuyergstno() {
		return buyergstno;
	}
	public void setBuyergstno(String buyergstno) {
		this.buyergstno = buyergstno;
	}
	public String getInvno() {
		return invno;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getBuyeraddress() {
		return buyeraddress;
	}
	public void setBuyeraddress(String buyeraddress) {
		this.buyeraddress = buyeraddress;
	}
	public String getInvhsn() {
		return invhsn;
	}
	public void setInvhsn(String invhsn) {
		this.invhsn = invhsn;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	public String getInvtotal() {
		return invtotal;
	}
	public void setInvtotal(String invtotal) {
		this.invtotal = invtotal;
	}
	public String getAmtinwords() {
		return amtinwords;
	}
	public void setAmtinwords(String amtinwords) {
		this.amtinwords = amtinwords;
	}
	public Set<EntryRecordDetail> getEntry_record_detail() {
		return entry_record_detail;
	}
	public void setEntry_record_detail(Set<EntryRecordDetail> entry_record_detail) {
		this.entry_record_detail = entry_record_detail;
	}
	@Override
	public String toString() {
		return "EntryRecord [id=" + id + ", partyname=" + partyname + ", buyergstno=" + buyergstno + ", invno=" + invno
				+ ", buyeraddress=" + buyeraddress + ", invhsn=" + invhsn + ", invdate=" + invdate + ", invtotal="
				+ invtotal + ", amtinwords=" + amtinwords + ", entry_record_detail=" + entry_record_detail + "]";
	}
	

}
