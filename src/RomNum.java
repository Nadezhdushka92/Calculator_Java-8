public enum RomNum {
    I("1"),
    II("2"),
    III("3"),
    IV("4"),
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
    IX("9"),
    X("10"),
    XI("11"),
    XII("12"),
    XIII("13"),
    XIV("14"),
    XV("15"),
    XVI("16"),
    XVII("17"),
    XVIII("18"),
    XIX("19"),
    XX("20"),
    XXX("30"),
    XL("40"),
    L("50"),
    LX("60"),
    LXX("70"),
    LXXX("80"),
    XC("90"),
    C("100");

    public String value;

    RomNum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static RomNum getByValue(String value) {
        for (RomNum rn : RomNum.values()) {
            if (rn.getValue().equals(value))
                return rn;
        }
        throw new IllegalArgumentException("No RomanNumber with value " + value);
    }
    //@Override
    //public String toString() {
    //   return "RomNum{" +
    //           "value=" + value +
    //          '}';
    //}
}
