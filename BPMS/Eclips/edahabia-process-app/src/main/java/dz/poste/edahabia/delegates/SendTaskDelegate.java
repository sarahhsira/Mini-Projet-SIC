package dz.poste.edahabia.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendTaskDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        String nomTache = execution.getCurrentActivityName();

        System.out.println("[SMS SIMULE] " + nomTache);

        System.out.println("[SMS SIMULE] Notification traitee.");
    }
}