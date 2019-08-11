package step;

public class StepWalker {
    public int count(int remainSteps) {
        if(remainSteps < 1) {
            return 0;
        }else if(remainSteps == 1) {
            return 1;
        }else if(remainSteps == 2) {
            return 2;
        } else {
            return count(remainSteps-1) + count(remainSteps -2);
        }

    }
}
