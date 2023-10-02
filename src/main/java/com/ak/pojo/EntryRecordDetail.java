//from and to is not allowed as db column names so added Gfrom and GTo in db
package com.ak.pojo;

import java.io.Serializable;

public class EntryRecordDetail implements Serializable {

	

	private String id;
	private String entryRecordId;
	private String srno;
    private String vechilenumber;
    private String lrno;
    private String lrdate;
    private String billtype;
    private String billqty;
    private String from;
    private String To;
    private String Freight;
    private String Detention;
    private String Unloading;
    private String Incentive;
    private String lrcharge;
    private String NGT;
    private String taxableamt;
    private String CGSTtax;
    private String sgsttax;
    private String igsttax;
    private String Total;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntryRecordId() {
		return entryRecordId;
	}
	public void setEntryRecordId(String entryRecordId) {
		this.entryRecordId = entryRecordId;
	}
    public String getSrno() {
		return srno;
	}
	public void setSrno(String srno) {
		this.srno = srno;
	}
	public String getVechilenumber() {
		return vechilenumber;
	}
	public void setVechilenumber(String vechilenumber) {
		this.vechilenumber = vechilenumber;
	}
	public String getLrno() {
		return lrno;
	}
	public void setLrno(String lrno) {
		this.lrno = lrno;
	}
	public String getLrdate() {
		return lrdate;
	}
	public void setLrdate(String lrdate) {
		this.lrdate = lrdate;
	}
	public String getBilltype() {
		return billtype;
	}
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}
	public String getBillqty() {
		return billqty;
	}
	public void setBillqty(String billqty) {
		this.billqty = billqty;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getFreight() {
		return Freight;
	}
	public void setFreight(String freight) {
		Freight = freight;
	}
	public String getDetention() {
		return Detention;
	}
	public void setDetention(String detention) {
		Detention = detention;
	}
	public String getUnloading() {
		return Unloading;
	}
	public void setUnloading(String unloading) {
		Unloading = unloading;
	}
	public String getIncentive() {
		return Incentive;
	}
	public void setIncentive(String incentive) {
		Incentive = incentive;
	}
	public String getLrcharge() {
		return lrcharge;
	}
	public void setLrcharge(String lrcharge) {
		this.lrcharge = lrcharge;
	}
	public String getNGT() {
		return NGT;
	}
	public void setNGT(String nGT) {
		NGT = nGT;
	}
	public String getTaxableamt() {
		return taxableamt;
	}
	public void setTaxableamt(String taxableamt) {
		this.taxableamt = taxableamt;
	}
	public String getCGSTtax() {
		return CGSTtax;
	}
	public void setCGSTtax(String cGSTtax) {
		CGSTtax = cGSTtax;
	}
	public String getSgsttax() {
		return sgsttax;
	}
	public void setSgsttax(String sgsttax) {
		this.sgsttax = sgsttax;
	}
	public String getIgsttax() {
		return igsttax;
	}
	public void setIgsttax(String igsttax) {
		this.igsttax = igsttax;
	}
	public String getTotal() {
		return Total;
	}
	public void setTotal(String total) {
		Total = total;
	}
	@Override
	public String toString() {
		return "EntryRecordDetail [id=" + id + ", entryRecordId=" + entryRecordId + ", srno=" + srno
				+ ", vechilenumber=" + vechilenumber + ", lrno=" + lrno + ", lrdate=" + lrdate + ", billtype="
				+ billtype + ", billqty=" + billqty + ", from=" + from + ", To=" + To + ", Freight=" + Freight
				+ ", Detention=" + Detention + ", Unloading=" + Unloading + ", Incentive=" + Incentive + ", lrcharge="
				+ lrcharge + ", NGT=" + NGT + ", taxableamt=" + taxableamt + ", CGSTtax=" + CGSTtax + ", sgsttax="
				+ sgsttax + ", igsttax=" + igsttax + ", Total=" + Total + "]";
	}
	
	
	
}
