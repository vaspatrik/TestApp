package ro.ubbcluj.softeng.server.service;

import java.util.ArrayList;
import java.util.List;

import ro.ubbcluj.softeng.server.model.DemoModel;

public class DemoService {
	private static List<DemoModel> data;
	
	public static List<DemoModel> getDataList() {
		if (data == null) {
			data = new ArrayList<DemoModel>();
			DemoModel dm1 = new DemoModel();
			dm1.setNumber(233);
			dm1.setSomeString("sfsdf");

			DemoModel dm2 = new DemoModel();
			dm2.setNumber(4343);
			dm2.setSomeString("kmmfk");

			DemoModel dm3 = new DemoModel();
			dm3.setNumber(544);
			dm3.setSomeString("lfg3");

			DemoModel dm4 = new DemoModel();
			dm4.setNumber(872);
			dm4.setSomeString("xckb34");

			data.add(dm1);
			data.add(dm2);
			data.add(dm3);
			data.add(dm4);
		}
		return data;
	}
	
	public static DemoModel getItem(Integer number) {
		List<DemoModel> list = getDataList();
		for (DemoModel demoModel : list) {
			if (demoModel.getNumber().equals(number)) {
				return demoModel;
			}
		}
		return null;
	}
	
	public static void save(DemoModel dm) {
		getDataList().add(dm);
	}
	
	public static DemoModel remove(int id) {
		try {
			return getDataList().remove(id);
		} catch(IndexOutOfBoundsException ex) {
			return null;
		}
	}
	
	public static DemoModel update(int id, DemoModel dm) {
		try {
			return getDataList().set(id, dm);
		} catch(IndexOutOfBoundsException | NullPointerException ex) {
			return null;
		}
	}
}
