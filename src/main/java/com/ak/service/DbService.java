package com.ak.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ak.dao.DbConnectionService;
import com.ak.pojo.EntryRecord;
import com.ak.pojo.EntryRecordDetail;

public class DbService {
	
	private Connection con;
	
	public DbService(){
		try {
		this.con=new DbConnectionService().getDbConnection();
		}catch (Exception e) {
			System.out.println("Error while creating database connection:"+ e.getMessage());
		}
		
	}
	
	
	
	
	
	private static final String JSON_ENTRY_SAVEPOINT="jsonentrysavepoint";
	
	public void insertRecords(List<EntryRecord> entryRecords)throws Exception {
		Savepoint savepoint=null;
		try {
			con.setAutoCommit(false);
			savepoint =	con.setSavepoint(JSON_ENTRY_SAVEPOINT);
		
		for (EntryRecord entryRecord : entryRecords) {
			insertEntryRecord(entryRecord);
		}
		con.commit();
		}catch (Exception e) {
			con.rollback(savepoint);
			con.commit();
			e.printStackTrace();
			throw new Exception("Error while inserting records:: "+e.getMessage());
		}finally {
			con.setAutoCommit(true);
		}
		
	}
	
	
	
	
	
	
	
	public  void insertEntryRecord(EntryRecord entryRecord)throws Exception {
		String query ="INSERT into entryRecord (id, partyname, buyergstno, invno, buyeraddress, invhsn, invdate, invtotal, amtinwords) VALUES(?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps = con.prepareStatement(query)) {
		String id=entryRecord.getId()==null?generateUUID():entryRecord.getId();
		ps.setObject(1, id);
		ps.setObject(2, entryRecord.getPartyname());
		ps.setObject(3, entryRecord.getBuyergstno());
		ps.setObject(4, entryRecord.getInvno());
		ps.setObject(5, entryRecord.getBuyeraddress());
		ps.setObject(6, entryRecord.getInvhsn());
		ps.setObject(7, entryRecord.getInvdate());
		ps.setObject(8, entryRecord.getInvtotal());
		ps.setObject(9, entryRecord.getAmtinwords());
        ps.execute();
        insertEntryRecordDetails(entryRecord.getEntry_record_detail(), id);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while creating db records for record-entry: buyergstno:"+entryRecord.getBuyergstno());
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	
	public void insertEntryRecordDetails(Set<EntryRecordDetail> entryRecordDetails,String entryRecordId)throws Exception {
    String query ="INSERT into entryRecordDetail (id, entryRecordId, srno, vechilenumber, lrno, lrdate, billtype, billqty, Gfrom, GTo, Freight,"
    		+ " Detention, Unloading, Incentive, lrcharge, NGT, taxableamt, CGSTtax, sgsttax, igsttax, Total) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
    try(PreparedStatement ps = con.prepareStatement(query)) {
    for (EntryRecordDetail entryRecordDetail : entryRecordDetails) {
    	
    	ps.setObject(1, generateUUID());
		ps.setObject(2, entryRecordId);
		ps.setObject(3, entryRecordDetail.getSrno());
		ps.setObject(4, entryRecordDetail.getVechilenumber());
		ps.setObject(5, entryRecordDetail.getLrno());
		ps.setObject(6, entryRecordDetail.getLrdate());
		ps.setObject(7, entryRecordDetail.getBilltype());
		ps.setObject(8, entryRecordDetail.getBillqty());
		ps.setObject(9, entryRecordDetail.getFrom());
		ps.setObject(10, entryRecordDetail.getTo());
		ps.setObject(11, entryRecordDetail.getFreight());
	    
		ps.setObject(12, entryRecordDetail.getDetention());
		ps.setObject(13, entryRecordDetail.getUnloading());
		ps.setObject(14, entryRecordDetail.getIncentive());
		ps.setObject(15, entryRecordDetail.getLrcharge());
		ps.setObject(16, entryRecordDetail.getNGT());
		ps.setObject(17, entryRecordDetail.getTaxableamt());
		ps.setObject(18, entryRecordDetail.getCGSTtax());
	
		ps.setObject(19, entryRecordDetail.getSgsttax());
		ps.setObject(20, entryRecordDetail.getIgsttax());
		ps.setObject(21, entryRecordDetail.getTotal());
		ps.addBatch();
          
	}
    ps.executeBatch();
    }catch (Exception e) {
		System.out.println("error while inserting record-details:"+ entryRecordId);
		throw new Exception(e.getMessage());
	}
	
}
	
	
	
	
	
static	public  String generateUUID() {
	 return	UUID.randomUUID().toString();
}

	
	
public static void main(String[] args) {
	System.out.println(generateUUID());
}
	
	
	
	@Override
	protected void finalize() throws Throwable {
		if(con!=null)
		this.con.close();
		super.finalize();
	}
	
}
