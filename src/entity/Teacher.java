package entity;

import java.util.Arrays;

public class Teacher {
    private String tNo;
    private String tN;
    private String title;
    private byte[] tImage; // ���ڴ洢ͼ����ֽ�����
    private String tEmail;
    private String tNumber;
    private String tINTRO; // ���Դ洢�ϳ��ı���ʹ��String����

    // ���캯����getter��setterʡ��

    public String getTNo() {
        return tNo;
    }

    public void setTNo(String tNo) {
        this.tNo = tNo;
    }

    public String gettN() {
        return tN;
    }

    public void settN(String tN) {
        this.tN = tN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] gettImage() {
        return tImage;
    }

    public void settImage(byte[] tImage) {
        this.tImage = tImage;
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String gettINTRO() {
        return tINTRO;
    }

    public void settINTRO(String tINTRO) {
        this.tINTRO = tINTRO;
    }

	@Override
	public String toString() {
		return "Teacher [tNo=" + tNo + ", tN=" + tN + ", title=" + title + ", tImage=" + Arrays.toString(tImage)
				+ ", tEmail=" + tEmail + ", tNumber=" + tNumber + ", tINTRO=" + tINTRO + "]";
	}
    
}
