package queries;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;

public class IntensityStatement {
	private EPStatement statement;

	public IntensityStatement(EPAdministrator admin, UpdateListener listener) {

		String query = "insert into AggIntPlayerEvent_"
				+ 5
				+ " "
				+ "select curIntEv.player_id as player_id, "
				+ "sum(case when intensity=0 "
				+ " then (curIntEv.distance) else 0 end) as standing_distance,"
				+ "sum(case when intensity=0 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as standing_time,"
				+ "sum(case when intensity=1 "
				+ " then (curIntEv.distance) else 0 end) as trot_distance, "
				+ "sum(case when intensity=1 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as trot_time,"
				+ "sum(case when intensity=2 "
				+ " then (curIntEv.distance) else 0 end) as low_distance, "
				+ "sum(case when intensity=2 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as low_time,"
				+ "sum(case when intensity=3 "
				+ " then (curIntEv.distance) else 0 end) as medium_distance, "
				+ "sum(case when intensity=3 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as medium_time,"
				+ "sum(case when intensity=4 "
				+ " then (curIntEv.distance) else 0 end) as high_distance, "
				+ "sum(case when intensity=4 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as high_time,"
				+ "sum(case when intensity=5 "
				+ " then (curIntEv.distance) else 0 end) as sprint_distance, "
				+ "sum(case when intensity=5 "
				+ " then (curIntEv.ts_stop - curIntEv.ts_start)/1000000000 else 0 end) as sprint_time"
				+ " from CurrentIntensityEvent.win:time(300000 sec) as curIntEv "
				+ "group by curIntEv.player_id";

		this.statement = admin.createEPL(query);
		this.statement.addListener(listener);

	}
}
