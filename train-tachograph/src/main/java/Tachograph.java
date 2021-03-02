import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class Tachograph {

    private Table<LocalDateTime,Integer,Integer> tachoData;

    public Tachograph() {
        tachoData = HashBasedTable.create();
    }

    public void addData(LocalDateTime date, Integer pos, Integer speed) {

        tachoData.put(date,pos,speed);
    }

    public int getSize(){
        return tachoData.size();
    }
}
