
package dz.poste.edahabia.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class EligibiliteDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        // Simulation : le client est considéré comme éligible
        boolean eligible = true;

        // Enregistrement de la variable dans Camunda
        execution.setVariable("eligible", eligible);

        System.out.println("[ELIGIBILITE] Vérification simulée.");
        System.out.println("[ELIGIBILITE] Résultat : " + eligible);
    }
}
