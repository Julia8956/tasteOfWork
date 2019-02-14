package model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.testPopup;

public class MOM implements Serializable {

	private String MOMTitle;
	private Date MOMDay;

	public MOM() {
	}

	public MOM(String MOMTitle, Date MOMDay) {
		super();
		this.MOMTitle = MOMTitle;
		this.MOMDay = MOMDay;

	}

	public String getMOMTitle() {
		return MOMTitle;
	}

	public Date getMOMDay() {
		return MOMDay;
	}

	public void setMOMTitle(String MOMTitle) {
		this.MOMTitle = MOMTitle;
	}

	public void setMOMDay(Date MOMDay) {
		this.MOMDay = MOMDay;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return MOMTitle + " " + sdf.format(MOMDay);
	}

}
