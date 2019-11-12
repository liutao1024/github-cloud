package cn.spring.mvn.core.ledger.entity;
/**
 * @author LiuTao @date 2019年11月12日 下午5:09:23
 * @ClassName: InsideAndOutsideDailyLedgerEntity 
 * @Description: 表内外日总账
 */
public class InsideAndOutsideDailyLedgerEntity {
	private String cropno;
	private String acctdt;
	private String brchno;
	private String itemcd;
	private String debit;
	public String getCropno() {
		return cropno;
	}
	public void setCropno(String cropno) {
		this.cropno = cropno;
	}
	public String getAcctdt() {
		return acctdt;
	}
	public void setAcctdt(String acctdt) {
		this.acctdt = acctdt;
	}
	public String getBrchno() {
		return brchno;
	}
	public void setBrchno(String brchno) {
		this.brchno = brchno;
	}
	public String getItemcd() {
		return itemcd;
	}
	public void setItemcd(String itemcd) {
		this.itemcd = itemcd;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}

	
}