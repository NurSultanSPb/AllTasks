package BigTask;
/*
Спам будем фильтровать по наличию указанных ключевых слов в тексте.
 */
public class SpamAnalyzer extends KeyWordAnalyzer {
    private String[] keywords;
    public SpamAnalyzer (String[] keywords){
        this.keywords = keywords;
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }
}
