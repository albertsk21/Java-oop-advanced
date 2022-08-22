package calculator;

import java.util.Deque;

public class RecallNumber implements Operation{

    private final Deque<Integer> memory;

    public RecallNumber(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
      return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return this.memory.size() != 0;
    }
}
