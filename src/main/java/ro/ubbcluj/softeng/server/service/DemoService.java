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
			dm1.setData("some data 1");

			DemoModel dm2 = new DemoModel();
		
			dm2.setData("some data 2");

			DemoModel dm3 = new DemoModel();
			dm3.setData("some data 3");

			DemoModel dm4 = new DemoModel();
			dm4.setData("some data 4");

			data.add(dm1);
			data.add(dm2);
			data.add(dm3);
			data.add(dm4);
		}
		return data;
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
