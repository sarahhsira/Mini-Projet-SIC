package dz.poste.edahabia.delegates;

import java.util.Set;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class EligibiliteDelegate implements JavaDelegate {

    // Simulation de la base des cartes déjà émises (numéros fictifs)
    private static final Set<String> CCP_AVEC_CARTE =
            Set.of("00987654321", "00555555555");

    @Override
    public void execute(DelegateExecution execution) {

        String ccp = String.valueOf(execution.getVariable("numeroCCP"));
        String tel = String.valueOf(execution.getVariable("telephone"));

        boolean ccpValide = ccp.matches("\\d{10,12}");
        boolean mobileValide = tel.matches("0[567]\\d{8}");
        boolean carteExistante = CCP_AVEC_CARTE.contains(ccp);

        boolean eligible = ccpValide && mobileValide && !carteExistante;

        String motif = "";
        if (!ccpValide) {
            motif = motif + "Numéro de compte CCP invalide. ";
        }
        if (!mobileValide) {
            motif = motif + "Numéro de téléphone mobile invalide. ";
        }
        if (carteExistante) {
            motif = motif + "Une carte EDAHABIA existe déjà pour ce compte.";
        }

        execution.setVariable("eligible", eligible);
        execution.setVariable("motifNonEligibilite", motif.trim());

        System.out.println("[ELIGIBILITE V2] CCP=" + ccp
                + " | ccpValide=" + ccpValide
                + " | mobileValide=" + mobileValide
                + " | carteExistante=" + carteExistante);
        System.out.println("[ELIGIBILITE V2] Résultat : " + eligible);
    }
}