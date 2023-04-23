public interface Person {

    String getName();
    String getType();
    int getNumOfGossips();
    void goToHome();
    LandMark getCurrLandmark();
    boolean isAtHome();
    void goToNewLandMark(LandMark landmark);
    Group getCurrGroup();
    void setGroup(Group group);
    void clearGroup();
    boolean isAlone();
}
