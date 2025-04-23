package uk.co.smitek.dddhex.dddhex;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import org.jmolecules.archunit.JMoleculesArchitectureRules.VerificationDepth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jmolecules.archunit.JMoleculesArchitectureRules.ensureHexagonal;

@AnalyzeClasses(packages = {
        "uk.co.smitek.dddhex.dddhex.products",
        "uk.co.smitek.dddhex.dddhex.orders",
        "uk.co.smitek.dddhex.dddhex.inventory",
}, importOptions = ImportOption.DoNotIncludeTests.class)
public class HexagonalDddTest {

    @ArchTest
    void secondaryAdaptorCanAccessApplication(JavaClasses classes) {

        var evaluationResult = ensureHexagonal(VerificationDepth.SEMI_STRICT)
                .evaluate(classes);

        assertThat(evaluationResult.getFailureReport().getDetails()).hasSize(0);

        var failureReport = evaluationResult.getFailureReport();
        if (!failureReport.isEmpty()) {
            System.out.println("Failure Report: " + failureReport);
        }

    }

    @ArchTest
    void secondariesCannotAccessApplication(JavaClasses classes) {

        var evaluationResult = ensureHexagonal(VerificationDepth.STRICT)
                .evaluate(classes);

        assertThat(evaluationResult.getFailureReport().getDetails()).hasSize(2);

        var failureReport = evaluationResult.getFailureReport();
        if (!failureReport.isEmpty()) {
            System.out.println("Failure Report: " + failureReport);
        }

    }

}
