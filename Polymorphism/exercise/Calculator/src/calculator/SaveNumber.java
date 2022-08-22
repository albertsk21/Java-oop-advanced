package calculator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SaveNumber implements Operation {
    private final Deque<Integer> memory;


    public SaveNumber(Deque<Integer> memory) {
    this.memory = memory;
    }


    @Override
    public void addOperand(int operand) {
            this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
