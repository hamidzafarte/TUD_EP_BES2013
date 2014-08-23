package epdebs.queries;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class BallPossessionListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents == null) {
			return;
		}
		for (EventBean theEvent : newEvents) {
			System.out.println("ball possession received :"
					+ theEvent.getUnderlying());
		}
	}
}