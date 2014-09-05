package eplab.anfragen;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class FileListener implements UpdateListener {
	String fileName;

	public FileListener(String fileName) {
		this.fileName = fileName;
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents == null) {
			return;
		}
		for (EventBean theEvent : newEvents) {
			System.out.println("ECHO:" + theEvent.getUnderlying());
		}
	}
}