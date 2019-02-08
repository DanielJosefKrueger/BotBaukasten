package main.framework;

import main.util.Sleeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionQueue extends Thread {

    private final int timeBetweenEvaluations;
    private final int timeBetweenActions;


    private final Map<Trigger, List<Action>> triggerToActions = new HashMap<>();
    private final Sleeper sleeper = new Sleeper();




    public ActionQueue(int timeBetweenEvaluations, int timeBetweenActions){
        this.timeBetweenEvaluations = timeBetweenEvaluations;
        this.timeBetweenActions = timeBetweenActions;
    }


    public void addActionsForTrigger(Action action, Trigger trigger) {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(action);
        triggerToActions.put(trigger, actions);
    }

    public void addActionsForTrigger(List<Action> actions, Trigger trigger) {
        triggerToActions.put(trigger, actions);
    }


    public void evaluateTriggers(){
        for (Map.Entry<Trigger, List<Action>> entry : triggerToActions.entrySet()) {
            if(entry.getKey().evaluate()){
                for (Action action : entry.getValue()) {
                    action.onTrigger();
                    sleeper.sleep(timeBetweenActions);
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();

        while(true){
            evaluateTriggers();
            sleeper.sleep(timeBetweenEvaluations);
        }

    }
}
