package dz.poste.edahabia.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ServiceTaskDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        String nomTache = execution.getCurrentActivityName();

        System.out.println("[SERVICE] Execution : " + nomTache);

        System.out.println("[SERVICE] Traitement termine.");
    }
}