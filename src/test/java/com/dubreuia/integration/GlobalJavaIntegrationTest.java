package com.dubreuia.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.dubreuia.integration.ActionTestFile.AccessCanBeTightened_KO;
import static com.dubreuia.integration.ActionTestFile.AccessCanBeTightened_OK;
import static com.dubreuia.integration.ActionTestFile.CustomUnqualifiedStaticMemberAccess_KO;
import static com.dubreuia.integration.ActionTestFile.CustomUnqualifiedStaticMemberAccess_OK;
import static com.dubreuia.integration.ActionTestFile.ExplicitTypeCanBeDiamond_KO;
import static com.dubreuia.integration.ActionTestFile.ExplicitTypeCanBeDiamond_OK;
import static com.dubreuia.integration.ActionTestFile.FieldCanBeFinal_KO;
import static com.dubreuia.integration.ActionTestFile.FieldCanBeFinal_OK;
import static com.dubreuia.integration.ActionTestFile.FinalPrivateMethod_KO;
import static com.dubreuia.integration.ActionTestFile.FinalPrivateMethod_OK;
import static com.dubreuia.integration.ActionTestFile.GenerateSerialVersionUID_KO;
import static com.dubreuia.integration.ActionTestFile.GenerateSerialVersionUID_OK;
import static com.dubreuia.integration.ActionTestFile.InspectionsAll_KO;
import static com.dubreuia.integration.ActionTestFile.InspectionsAll_OK;
import static com.dubreuia.integration.ActionTestFile.LocalCanBeFinalExceptImplicit_KO;
import static com.dubreuia.integration.ActionTestFile.LocalCanBeFinalExceptImplicit_OK;
import static com.dubreuia.integration.ActionTestFile.LocalCanBeFinal_KO;
import static com.dubreuia.integration.ActionTestFile.LocalCanBeFinal_OK;
import static com.dubreuia.integration.ActionTestFile.MethodMayBeStatic_KO;
import static com.dubreuia.integration.ActionTestFile.MethodMayBeStatic_OK;
import static com.dubreuia.integration.ActionTestFile.MissingOverrideAnnotation_KO;
import static com.dubreuia.integration.ActionTestFile.MissingOverrideAnnotation_OK;
import static com.dubreuia.integration.ActionTestFile.SuppressAnnotation_KO;
import static com.dubreuia.integration.ActionTestFile.SuppressAnnotation_OK;
import static com.dubreuia.integration.ActionTestFile.UnnecessaryFinalOnLocalVariableOrParameter_KO;
import static com.dubreuia.integration.ActionTestFile.UnnecessaryFinalOnLocalVariableOrParameter_OK;
import static com.dubreuia.integration.ActionTestFile.UnnecessarySemicolon_KO;
import static com.dubreuia.integration.ActionTestFile.UnnecessarySemicolon_OK;
import static com.dubreuia.integration.ActionTestFile.UnnecessaryThis_KO;
import static com.dubreuia.integration.ActionTestFile.UnnecessaryThis_OK;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedFieldAccess_KO;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedFieldAccess_OK;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedMethodAccess_KO;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedMethodAccess_OK;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedStaticMemberAccess_KO;
import static com.dubreuia.integration.ActionTestFile.UnqualifiedStaticMemberAccess_OK;
import static com.dubreuia.integration.ActionTestFile.UseBlocks_KO;
import static com.dubreuia.integration.ActionTestFile.UseBlocks_OK;
import static com.dubreuia.model.Action.accessCanBeTightened;
import static com.dubreuia.model.Action.activate;
import static com.dubreuia.model.Action.activateOnBatch;
import static com.dubreuia.model.Action.activateOnShortcut;
import static com.dubreuia.model.Action.customUnqualifiedStaticMemberAccess;
import static com.dubreuia.model.Action.explicitTypeCanBeDiamond;
import static com.dubreuia.model.Action.fieldCanBeFinal;
import static com.dubreuia.model.Action.finalPrivateMethod;
import static com.dubreuia.model.Action.generateSerialVersionUID;
import static com.dubreuia.model.Action.localCanBeFinal;
import static com.dubreuia.model.Action.localCanBeFinalExceptImplicit;
import static com.dubreuia.model.Action.methodMayBeStatic;
import static com.dubreuia.model.Action.missingOverrideAnnotation;
import static com.dubreuia.model.Action.suppressAnnotation;
import static com.dubreuia.model.Action.unnecessaryFinalOnLocalVariableOrParameter;
import static com.dubreuia.model.Action.unnecessarySemicolon;
import static com.dubreuia.model.Action.unnecessaryThis;
import static com.dubreuia.model.Action.unqualifiedFieldAccess;
import static com.dubreuia.model.Action.unqualifiedMethodAccess;
import static com.dubreuia.model.Action.unqualifiedStaticMemberAccess;
import static com.dubreuia.model.Action.useBlocks;
import static com.dubreuia.model.Action.useGlobalConfiguration;


class GlobalJavaIntegrationTest extends IntegrationTest {

    @BeforeEach
    void useGlobalConfiguration() {
        projectStorage.setEnabled(useGlobalConfiguration, true);
    }

    @Test
    void should_fieldCanBeFinal_add_final_to_field() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(fieldCanBeFinal, true);
        assertSaveAction(FieldCanBeFinal_KO, FieldCanBeFinal_OK);
    }

    @Test
    void should_fieldCanBeFinal_add_final_to_field_on_shortcut() {
        globalStorage.setEnabled(activateOnShortcut, true);
        globalStorage.setEnabled(fieldCanBeFinal, true);
        assertSaveActionShortcut(FieldCanBeFinal_KO, FieldCanBeFinal_OK);
    }

    @Test
    void should_fieldCanBeFinal_add_final_to_field_on_batch() {
        globalStorage.setEnabled(activateOnBatch, true);
        globalStorage.setEnabled(fieldCanBeFinal, true);
        assertSaveActionBatch(FieldCanBeFinal_KO, FieldCanBeFinal_OK);
    }

    @Test
    void should_localCanBeFinal_add_final_to_local_variable_and_parameters() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(localCanBeFinal, true);
        assertSaveAction(LocalCanBeFinal_KO, LocalCanBeFinal_OK);
    }

    @Test
    void should_localCanBeFinalExceptImplicit_add_final_to_variable_but_not_resources() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(localCanBeFinalExceptImplicit, true);
        assertSaveAction(LocalCanBeFinalExceptImplicit_KO, LocalCanBeFinalExceptImplicit_OK);
    }

    @Test
    @Disabled("do not work")
    void should_methodMayBeStatic_add_static_keyword_to_method() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(methodMayBeStatic, true);
        assertSaveAction(MethodMayBeStatic_KO, MethodMayBeStatic_OK);
    }

    @Test
    void should_unqualifiedFieldAccess_add_this_to_field_access() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unqualifiedFieldAccess, true);
        assertSaveAction(UnqualifiedFieldAccess_KO, UnqualifiedFieldAccess_OK);
    }

    @Test
    void should_unqualifiedMethodAccess_add_this_to_method_access() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unqualifiedMethodAccess, true);
        assertSaveAction(UnqualifiedMethodAccess_KO, UnqualifiedMethodAccess_OK);
    }

    @Test
    void should_unqualifiedStaticMemberAccess_add_this_to_method_access() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unqualifiedStaticMemberAccess, true);
        assertSaveAction(UnqualifiedStaticMemberAccess_KO, UnqualifiedStaticMemberAccess_OK);
    }

    @Test
    void should_customUnqualifiedStaticMemberAccess_add_this_to_method_access() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(customUnqualifiedStaticMemberAccess, true);
        assertSaveAction(CustomUnqualifiedStaticMemberAccess_KO, CustomUnqualifiedStaticMemberAccess_OK);
    }

    @Test
    void should_missingOverrideAnnotation_add_override_annotation() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(missingOverrideAnnotation, true);
        assertSaveAction(MissingOverrideAnnotation_KO, MissingOverrideAnnotation_OK);
    }

    @Test
    void should_useBlocks_add_blocks_to_if_else_while_for() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(useBlocks, true);
        assertSaveAction(UseBlocks_KO, UseBlocks_OK);
    }

    @Test
    @Disabled("do not work")
    void should_generateSerialVersionUID_generates_serial_version_uid_for_serializable_class() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(generateSerialVersionUID, true);
        assertSaveAction(GenerateSerialVersionUID_KO, GenerateSerialVersionUID_OK);
    }

    @Test
    void should_unnecessaryThis_removes_this_on_method_and_field() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unnecessaryThis, true);
        assertSaveAction(UnnecessaryThis_KO, UnnecessaryThis_OK);
    }

    @Test
    void should_finalPrivateMethod_removes_final_on_private_methods() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(finalPrivateMethod, true);
        assertSaveAction(FinalPrivateMethod_KO, FinalPrivateMethod_OK);
    }

    @Test
    void should_unnecessaryFinalOnLocalVariableOrParameter_removes_final_on_local_varible_and_parameters() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unnecessaryFinalOnLocalVariableOrParameter, true);
        assertSaveAction(UnnecessaryFinalOnLocalVariableOrParameter_KO, UnnecessaryFinalOnLocalVariableOrParameter_OK);
    }

    @Test
    @Disabled("do not work")
    void should_explicitTypeCanBeDiamond_removes_explicit_diamond() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(explicitTypeCanBeDiamond, true);
        assertSaveAction(ExplicitTypeCanBeDiamond_KO, ExplicitTypeCanBeDiamond_OK);
    }

    @Test
    void should_suppressAnnotation_remove_unnecessary_suppress_warning_annotation() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(suppressAnnotation, true);
        assertSaveAction(SuppressAnnotation_KO, SuppressAnnotation_OK);
    }

    @Test
    void should_unnecessarySemicolon_remove_unnecessary_semicolon() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(unnecessarySemicolon, true);
        assertSaveAction(UnnecessarySemicolon_KO, UnnecessarySemicolon_OK);
    }

    @Test
    void should_accessCanBeTightened_remove_unnecessary_semicolon() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(accessCanBeTightened, true);
        assertSaveAction(AccessCanBeTightened_KO, AccessCanBeTightened_OK);
    }

    @Test
    void should_inspectionsAll_boogaloo() {
        globalStorage.setEnabled(activate, true);
        globalStorage.setEnabled(useBlocks, true);
        globalStorage.setEnabled(accessCanBeTightened, true);
        globalStorage.setEnabled(unnecessarySemicolon, true);
        assertSaveAction(InspectionsAll_KO, InspectionsAll_OK);
    }

}