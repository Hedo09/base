import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDate;

public class Tachograph {

    private Table<LocalDate,Integer,Integer> tachoData;

    public Tachograph() {
        tachoData = HashBasedTable.create();
    }

    public void addData(LocalDate date,Integer pos,Integer speed) {

        tachoData.put(date,pos,speed);
    }

    public int getSize(){
        return tachoData.size();
    }
}
