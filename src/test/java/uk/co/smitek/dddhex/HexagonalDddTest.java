package uk.co.smitek.dddhex;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import org.jmolecules.archunit.JMoleculesArchitectureRules.VerificationDepth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jmolecules.archunit.JMoleculesArchitectureRules.ensureHexagonal;

@AnalyzeClasses(packages = {
        "uk.co.smitek.dddhex.products"
}, importOptions = ImportOption.DoNotIncludeTests.class)
public class HexagonalDddTest {

    @ArchTest
    void secondariesCanAccessApplication_When_SEMI_STRICT(JavaClasses classes) {

        var evaluationResult = ensureHexagonal(VerificationDepth.SEMI_STRICT)
                .evaluate(classes);

        var failureReport = evaluationResult.getFailureReport();
        System.out.println("Failure Report: " + failureReport.getDetails());

        assertThat(failureReport.getDetails()).hasSize(0);

    }

    @ArchTest
    void secondariesCannotAccessApplication_When_STRICT(JavaClasses classes) {

        var evaluationResult = ensureHexagonal(VerificationDepth.STRICT)
                .evaluate(classes);

        var failureReport = evaluationResult.getFailureReport();
        System.out.println("Failure Report: " + failureReport.getDetails());

        assertThat(failureReport.getDetails()).hasSize(2);

    }

}
