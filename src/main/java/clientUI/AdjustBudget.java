package clientUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdjustBudget extends SendReceive{
    public AdjustBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

}
