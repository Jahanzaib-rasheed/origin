package task2;

public class Sentence {
	private int SentenceID, RowId,chkbox1,chkbox2,chkbox3,chkbox4,chkbox5,chkbox6,chkbox7,Skip,Submit;
	private String Sentence;
	public int getChkbox1() {
		return chkbox1;
	}
	public void setChkbox1(int chkbox1) {
		this.chkbox1 = chkbox1;
	}
	public int getChkbox2() {
		return chkbox2;
	}
	public void setChkbox2(int chkbox2) {
		this.chkbox2 = chkbox2;
	}
	public int getChkbox3() {
		return chkbox3;
	}
	public void setChkbox3(int chkbox3) {
		this.chkbox3 = chkbox3;
	}
	public int getChkbox4() {
		return chkbox4;
	}
	public void setChkbox4(int chkbox4) {
		this.chkbox4 = chkbox4;
	}
	public int getChkbox5() {
		return chkbox5;
	}
	public void setChkbox5(int chkbox5) {
		this.chkbox5 = chkbox5;
	}
	public int getChkbox6() {
		return chkbox6;
	}
	public void setChkbox6(int chkbox6) {
		this.chkbox6 = chkbox6;
	}
	public int getChkbox7() {
		return chkbox7;
	}
	public void setChkbox7(int chkbox7) {
		this.chkbox7 = chkbox7;
	}
	public int getSkip() {
		return Skip;
	}
	public void setSkip(int skip) {
		Skip = skip;
	}
	public int getSubmit() {
		return Submit;
	}
	public void setSubmit(int submit) {
		Submit = submit;
	}
	public int getSentenceID() {
		return SentenceID;
	}
	public void setSentenceID(int sentenceID) {
		SentenceID = sentenceID;
	}
	public int getRowId() {
		return RowId;
	}
	public void setRowId(int rowId) {
		RowId = rowId;
	}
	public String getSentence() {
		return Sentence;
	}
	public void setSentence(String sentence) {
		Sentence = sentence;
	}
	public void SubmitIncrcerment(){
		Submit++;
	}
	public void SkipIncrcerment(){
		Skip++;
	}
	public void chbox1Incrcerment(){
		chkbox1++;
	}
	public void chbox2Incrcerment(){
		chkbox2++;
	}
	public void chbox3Incrcerment(){
		chkbox3++;
	}
	public void chbox4Incrcerment(){
		chkbox4++;
	}
	public void chbox5Incrcerment(){
		chkbox5++;
	}
	public void chbox6Incrcerment(){
		chkbox6++;
	}
	public void chbox7Incrcerment(){
		chkbox7++;
	}
}
