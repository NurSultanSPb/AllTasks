package BigTask;
/*
Негативное содержание будем определять по наличию одного из трех смайликов -  :( =( :|.
 */
public class NegativeTextAnalyzer extends KeyWordAnalyzer {

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return new String[] {":(", "=(", ":|"};
    }
}
