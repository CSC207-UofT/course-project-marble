package clientUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ResetBudget extends SendReceive{
    public ResetBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
}
