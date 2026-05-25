package io.github.cbs.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeGrade {

    CLERICAL("Clerical"),

    SUB_STAFF("Sub Staff"),

    OFFICER_SCALE_I("Officer Scale I"),

    MANAGER_SCALE_II("Manager Scale II"),

    SENIOR_MANAGER_SCALE_III("Senior Manager Scale III"),

    CHIEF_MANAGER_SCALE_IV("Chief Manager Scale IV"),

    ASSISTANT_GENERAL_MANAGER_SCALE_V("Assistant General Manager Scale V"),

    DEPUTY_GENERAL_MANAGER_SCALE_VI("Deputy General Manager Scale VI"),

    GENERAL_MANAGER_SCALE_VII("General Manager Scale VII");

    private final String value;

    EmployeeGrade(String value) {
        this.value = value;
    }
}