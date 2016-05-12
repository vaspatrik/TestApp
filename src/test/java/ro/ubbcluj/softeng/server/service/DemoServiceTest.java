package ro.ubbcluj.softeng.server.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ro.ubbcluj.softeng.server.model.DemoModel;

public class DemoServiceTest {


	@Test
	public void testSave_save_Success() {
		DemoModel dm = new DemoModel();
		dm.setData("data");
		DemoService.save(dm);
		List<DemoModel> list = DemoService.getDataList();
		Assert.assertEquals(dm.getData(), list.get(list.size() - 1).getData());
	}

	@Test
	public void testRemove_remove_Success() {
		List<DemoModel> list1 = new ArrayList<DemoModel>(DemoService.getDataList());
		DemoService.remove(list1.size()-1);
		List<DemoModel> list2 = DemoService.getDataList();
		
		for (int i = 0; i< list2.size(); ++i) {
			Assert.assertEquals(list1.get(i).getData(), list2.get(i).getData());
		}
		Assert.assertEquals(list2.size(), list1.size() - 1);
	}

}
