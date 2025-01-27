package com.example.zpo.university_class;

public enum ClassType {
    LECTURE(1),
    LAB(2),
    Exercise(3);

    private final int code;

    ClassType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ClassType fromCode(int code) {
        for (ClassType type : ClassType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code for ClassType: " + code);
    }
}
